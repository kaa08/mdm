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
import project.mdm.dto.response.review.ResReviewDetailsDto;
import project.mdm.dto.response.review.ResReviewListDto;
import project.mdm.dto.response.review.ResReviewWriteDto;
import project.mdm.entity.Member;
import project.mdm.entity.Review;
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

    public Page<ResReviewListDto> getAllReviews(Pageable pageable) {
        Page<Review> reviews = reviewRepository.findAllWithMemberAndComments(pageable);
        List<ResReviewListDto> list = reviews.getContent().stream()
                .map(ResReviewListDto::fromEntity)
                .collect(Collectors.toList());
        return new PageImpl<>(list, pageable, reviews.getTotalElements());
    }

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

    public ResReviewWriteDto write(ReviewWriteDto writeDTO, Member member) {
        Review review = ReviewWriteDto.ofEntity(writeDTO);
        Member writeMember = memberRepository.findByEmail(member.getEmail()).orElseThrow(
                () -> new ResourceNotFoundException("Member", "Member Email", member.getEmail())
        );
        review.setMappingMember(writeMember);
        Review saveReview = reviewRepository.save(review);
        return ResReviewWriteDto.fromEntity(saveReview, writeMember.getUsername(), writeMember.getDriveExp());
    }

    public ResReviewDetailsDto detail(Long reviewId) {
        Review findReview = reviewRepository.findByIdWithMemberAndComments(reviewId).orElseThrow(
                () -> new ResourceNotFoundException("Review", "Review Id", String.valueOf(reviewId))
        );
        findReview.upViewCount();
        return ResReviewDetailsDto.fromEntity(findReview);
    }

    public ResReviewDetailsDto update(Long reviewId, ReviewUpdateDto reviewDTO) {
        Review updateReview = reviewRepository.findByIdWithMemberAndComments(reviewId).orElseThrow(
                () -> new ResourceNotFoundException("Review", "reviewId", String.valueOf(reviewId))
        );
        updateReview.update(reviewDTO.getTitle(), reviewDTO.getContent());
        return ResReviewDetailsDto.fromEntity(updateReview);
    }

    public void delete(Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }
}
