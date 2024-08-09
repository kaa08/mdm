package project.mdm.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import project.mdm.dto.request.member.MemberUpdateDto;
import project.mdm.dto.request.review.ReviewWriteDto;
import project.mdm.dto.response.board.ResBoardListDto;
import project.mdm.dto.response.comment.ResCommentDto;
import project.mdm.dto.response.history.ResHistoryListDto;
import project.mdm.dto.response.inquiry.ResInquiryListDto;
import project.mdm.dto.response.member.MemberResponseDto;
import project.mdm.dto.response.review.ResReviewListDto;
import project.mdm.dto.response.review.ResReviewWriteDto;
import project.mdm.entity.Member;
import project.mdm.service.*;

@RestController
@RequestMapping("/mypage")
@RequiredArgsConstructor
@Slf4j
public class MyPageController {
    private final BoardService boardService;
    private final CommentService commentService;
    private final InquiryService inquiryService;
    private final MemberService memberService;
    private final HistoryService historyService;
    private final ReviewService reviewService;

    // 마이페이지 - 사용자가 쓴 커뮤니티 게시글 전체 조회, 페이징 처리
    @GetMapping("/board/list")
    public ResponseEntity<Page<ResBoardListDto>> boardList(
            @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
            @AuthenticationPrincipal Member member) {
        Page<ResBoardListDto> listDTO = boardService.getAllBoardByMember(pageable, member);
        return ResponseEntity.status(HttpStatus.OK).body(listDTO);
    }

    // 마이페이지 - 사용자가 쓴 커뮤니티 댓글 전체 조회, 페이징 처리
    @GetMapping("/comment/list")
    public ResponseEntity<Page<ResCommentDto>> commentList(
            @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
            @AuthenticationPrincipal Member member
    ) {
        Page<ResCommentDto> listDTO = commentService.getCommentByMember(pageable, member);
        return ResponseEntity.status(HttpStatus.OK).body(listDTO);
    }

    // 마이페이지 - 사용자가 쓴 문의하기 글 전체 조회, 페이징 처리
    @GetMapping("/inquiry/list")
    public ResponseEntity<Page<ResInquiryListDto>> inquiryList(
            @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
            @AuthenticationPrincipal Member member
    ) {
        Page<ResInquiryListDto> listDTO = inquiryService.getAllInquiryByMember(pageable, member);
        return ResponseEntity.status(HttpStatus.OK).body(listDTO);
    }

    // 마이페이지 - 사용자가 쓴 후기글 전체 조회, 페이징 처리
    @GetMapping("/review/list")
    public ResponseEntity<Page<ResReviewListDto>> reviewList(
            @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
            @AuthenticationPrincipal Member member
    ) {
        Page<ResReviewListDto> listDTO = reviewService.getAllReviewByMember(pageable, member);
        return ResponseEntity.status(HttpStatus.OK).body(listDTO);
    }

    // 마이페이지 - 사용자 정보 수정
    @PatchMapping("/user/update")
    public ResponseEntity<MemberResponseDto> update(
            @AuthenticationPrincipal Member member,
            @RequestBody MemberUpdateDto memberUpdateDTO) {
        MemberResponseDto memberUpdate = memberService.update(member, memberUpdateDTO);
        return ResponseEntity.status(HttpStatus.OK).body(memberUpdate);
    }

    // 마이페이지 - 사용자 정보 조회
    @GetMapping("/user/update")
    public ResponseEntity<MemberResponseDto> getMember(
            @AuthenticationPrincipal Member member) {
        MemberResponseDto memberInfo = memberService.getMemberInfo(member.getEmail());
        return ResponseEntity.status(HttpStatus.OK).body(memberInfo);
    }

    // 마이페이지 - 사용자가 작성한 커뮤니티 게시글 삭제
    @DeleteMapping("/board/list/{boardId}/delete")
    public ResponseEntity<Long> deleteBoard(@PathVariable Long boardId) {
        boardService.delete(boardId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // 마이페이지 - 사용자가 작성한 커뮤니티 댓글 삭제
    @DeleteMapping("/comment/list/{commentId}/delete")
    public ResponseEntity<Long> deleteComment(@PathVariable Long commentId) {
        commentService.delete(commentId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // 마이페이지 - 사용자가 작성한 문의글 삭제
    @DeleteMapping("/inquiry/list/{inquiryId}/delete")
    public ResponseEntity<Long> deleteInquiry(@PathVariable Long inquiryId) {
        inquiryService.delete(inquiryId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // 마이페이지 - 사용자가 작성한 후기글 삭제
    @DeleteMapping("/review/list/{reviewId}/delete")
    public ResponseEntity<Long> deleteReview(@PathVariable Long reviewId) {
        inquiryService.delete(reviewId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // 마이페이지 - 사용자 탈퇴
    @DeleteMapping("/user/update/{memberId}/delete")
    public ResponseEntity<Long> deleteMember(@PathVariable Long memberId) {
        memberService.delete(memberId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // 마이페이지 - 사용가 과거 기록 목록 조회, 페이징 처리
    @GetMapping("/history/list")
    public ResponseEntity<Page<ResHistoryListDto>> historyList(
            @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable,
            @AuthenticationPrincipal Member member) {
        Page<ResHistoryListDto> listDTO = historyService.getAllHistoryByMember(pageable, member);
        return ResponseEntity.status(HttpStatus.OK).body(listDTO);
    }

    // 마이페이지 - 리뷰글(측정하기 후기) 작성
    @GetMapping("/history/list/review/write")
    public ResponseEntity<ResReviewWriteDto> write(
            @RequestBody ReviewWriteDto reviewDTO,
            @AuthenticationPrincipal Member member
    ) {
        Thread currentThread = Thread.currentThread();
        log.info("현재 진행 중인 스레드: " + currentThread.getName());
        ResReviewWriteDto saveReviewDTO = reviewService.write(reviewDTO, member, reviewDTO.getHistoryId());
        return ResponseEntity.status(HttpStatus.CREATED).body(saveReviewDTO);
    }
}
