package project.mdm.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.mdm.common.exception.ResourceNotFoundException;
import project.mdm.dto.request.board.SearchData;
import project.mdm.dto.request.review.ReviewUpdateDto;
import project.mdm.dto.request.review.ReviewWriteDto;
import project.mdm.dto.response.board.ResBoardListDto;
import project.mdm.dto.response.review.ResReviewDetailsDto;
import project.mdm.dto.response.review.ResReviewListDto;
import project.mdm.dto.response.review.ResReviewWriteDto;
import project.mdm.entity.Board;
import project.mdm.entity.History;
import project.mdm.entity.Member;
import project.mdm.entity.Review;
import project.mdm.repository.HistoryRepository;
import project.mdm.repository.MemberRepository;
import project.mdm.repository.ReviewRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final HistoryRepository historyRepository;

    // 후기 게시판 - 후기글 목록 조회
    public Page<ResReviewListDto> getAllReviews(Pageable pageable) {
        Page<Review> reviews = reviewRepository.findAllWithMember(pageable);
        List<ResReviewListDto> list = reviews.getContent().stream()
                .map(ResReviewListDto::fromEntity)
                .collect(Collectors.toList());
        return new PageImpl<>(list, pageable, reviews.getTotalElements());
    }

    // 후기 게시판 - 후기글 검색
    public Page<ResReviewListDto> search(SearchData searchData, Pageable pageable) {
        Page<Review> result = null;

        if (!searchData.getTitle().isEmpty()) {
            result = reviewRepository.findAllTitleContaining(searchData.getTitle(), pageable);
        } else if (!searchData.getContent().isEmpty()) {
            result = reviewRepository.findAllContentContaining(searchData.getContent(), pageable);
        } else if (!searchData.getWriterName().isEmpty()) {
            result = reviewRepository.findAllUsernameContaining(searchData.getWriterName(), pageable);
        }
        List<ResReviewListDto> list = result.getContent().stream()
                .map(ResReviewListDto::fromEntity)
                .collect(Collectors.toList());
        return new PageImpl<>(list, pageable, result.getTotalElements());
    }

    // 후기 게시판 - 후기글 작성
    public ResReviewWriteDto write(ReviewWriteDto writeDTO, Member member, Long historyId) {
        Review review = ReviewWriteDto.ofEntity(writeDTO);
        History findHistory = historyRepository.findById(historyId).orElseThrow(
                () -> new ResourceNotFoundException("History", "History Id", historyId.toString())
        );
        Member writeMember = memberRepository.findByEmail(member.getEmail()).orElseThrow(
                () -> new ResourceNotFoundException("Member", "Member Email", member.getEmail())
        );
        review.setMappingHistory(findHistory);
        review.setMappingMember(writeMember);
        Review saveReview = reviewRepository.save(review);
        return ResReviewWriteDto.fromEntity(saveReview, writeMember.getNickname(), member.getUsername(), writeMember.getDriveExp());
    }

    // 후기 게시판 - 후기글 조회
    public ResReviewDetailsDto detail(Long reviewId) {
        Review findReview = reviewRepository.findByIdWithMember(reviewId).orElseThrow(
                () -> new ResourceNotFoundException("Review", "Review Id", String.valueOf(reviewId))
        );
        findReview.upViewCount();
        return ResReviewDetailsDto.fromEntity(findReview);
    }

    // 마이페이지 - 사용자 별 후기글 조회
    public Page<ResReviewListDto> getAllReviewByMember(Pageable pageable, Member member) {
        Page<Review> reviews = reviewRepository.findAllByMember(pageable, member);
        List<ResReviewListDto> list = reviews.getContent().stream()
                .map(ResReviewListDto::fromEntity)
                .collect(Collectors.toList());
        return new PageImpl<>(list, pageable, reviews.getTotalElements());
    }

    // 후기 게시판 - 후기글 수정
    public ResReviewDetailsDto update(Long reviewId, ReviewUpdateDto reviewDTO) {
        Review updateReview = reviewRepository.findByIdWithMember(reviewId).orElseThrow(
                () -> new ResourceNotFoundException("Review", "reviewId", String.valueOf(reviewId))
        );
        updateReview.update(reviewDTO.getTitle(), reviewDTO.getContent());
        return ResReviewDetailsDto.fromEntity(updateReview);
    }

    // 후기 게시판 - 후기글 삭제
    public void delete(Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }
}
