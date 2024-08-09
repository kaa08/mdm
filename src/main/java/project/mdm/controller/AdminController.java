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
import project.mdm.dto.request.inquiry.InquiryWriteDto;
import project.mdm.dto.request.notice.NoticeUpdateDto;
import project.mdm.dto.request.notice.NoticeWriteDto;
import project.mdm.dto.response.board.ResBoardListDto;
import project.mdm.dto.response.inquiry.ResInquiryListDto;
import project.mdm.dto.response.inquiry.ResInquiryWriteDto;
import project.mdm.dto.response.member.MemberResponseDto;
import project.mdm.dto.response.notice.ResNoticeDetailsDto;
import project.mdm.dto.response.notice.ResNoticeListDto;
import project.mdm.dto.response.notice.ResNoticeWriteDto;
import project.mdm.dto.response.review.ResReviewListDto;
import project.mdm.dto.response.review.ResReviewWriteDto;
import project.mdm.entity.Member;
import project.mdm.service.*;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
@Slf4j
public class AdminController {

    private final MemberService memberService;
    private final BoardService boardService;
    private final ReviewService reviewService;
    private final InquiryService inquiryService;
    private final NoticeService noticeService;

    // 관리자 페이지 - 전체 사용자 조회
    @GetMapping("/user/list")
    public ResponseEntity<Page<MemberResponseDto>> getAllMembers(Pageable pageable) {
        Page<MemberResponseDto> members = memberService.getAllMembers(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(members);
    }

    // 관리자 페이지 - 사용자 삭제
    @DeleteMapping("/user/delete/{id}")
    public ResponseEntity<MemberResponseDto> deleteMember(@PathVariable Long id) {
        memberService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // 관리자 페이지 - 커뮤니티 게시판 조회
    @GetMapping("/board/list")
    public ResponseEntity<Page<ResBoardListDto>> boardList(
            @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<ResBoardListDto> listDTO = boardService.getAllBoards(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(listDTO);
    }

    // 관리자 페이지 - 커뮤니티 게시판 글 삭제
    @DeleteMapping("/board/delete/{id}")
    public ResponseEntity<ResBoardListDto> deleteBoard(@PathVariable Long id) {
        boardService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // 관리자 페이지 - 리뷰 게시판 조회
    @GetMapping("/review/list")
    public ResponseEntity<Page<ResReviewListDto>> reviewList(
            @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        Page<ResReviewListDto> listDTO = reviewService.getAllReviews(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(listDTO);
    }

    // 관리자 페이지 - 리뷰 글 삭제
    @DeleteMapping("/review/delete/{id}")
    public ResponseEntity<ResReviewListDto> deleteReview(@PathVariable Long id) {
        reviewService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // 관리자 페이지 - 문의사항 게시판 조회
    @GetMapping("/inquiry/list")
    public ResponseEntity<Page<ResInquiryListDto>> inquiryList(
            @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<ResInquiryListDto> listDTO = inquiryService.getAllInquiries(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(listDTO);
    }

    // 관리자 페이지 - 문의사항 답변
    @PatchMapping("/inquiry/{id}/answer")
    public ResponseEntity<ResInquiryWriteDto> writeAnswer(
            @RequestBody InquiryWriteDto inquiryDTO,
            @PathVariable Long id,
            @AuthenticationPrincipal Member member) {
        Thread currentThread = Thread.currentThread();
        log.info("현재 실행중인 스레드: " + currentThread.getName());
        ResInquiryWriteDto saveInquiryDTO = inquiryService.writeAnswer(id, inquiryDTO, member);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveInquiryDTO);
    }

    // 관리자 페이지 - 문의사항 글 삭제
    @DeleteMapping("/inquiry/{inquiryId}/delete")
    public ResponseEntity<Long> delete(@PathVariable Long inquiryId) {
        inquiryService.delete(inquiryId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // 관리자 페이지 - 공지사항 게시판 조회
    @GetMapping("/notice/list")
    public ResponseEntity<Page<ResNoticeListDto>> noticeList(
            @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<ResNoticeListDto> listDTO = noticeService.getAllNotices(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(listDTO);
    }

    // 관리자 페이지 - 공지사항 게시판 글 쓰기
    @PostMapping("/notice/write")
    public ResponseEntity<ResNoticeWriteDto> write(
            @RequestBody NoticeWriteDto noticeDTO,
            @AuthenticationPrincipal Member member) {
        Thread currentThread = Thread.currentThread();
        log.info("현재 실행 중인 스레드: " + currentThread.getName());
        ResNoticeWriteDto saveNoticeDTO = noticeService.write(noticeDTO, member);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveNoticeDTO);
    }

    // 관리자 페이지 - 공지사항 게시판 글 수정
    @PatchMapping("/notice/{noticeId}/update")
    public ResponseEntity<ResNoticeDetailsDto> update(
            @PathVariable Long noticeId,
            @RequestBody NoticeUpdateDto noticeDTO) {
        ResNoticeDetailsDto updateNoticeDTO = noticeService.update(noticeId, noticeDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updateNoticeDTO);
    }

    // 관리자 페이지 - 공지사항 게시판 글 삭제
    @DeleteMapping("/notice/delete/{id}")
    public ResponseEntity<ResNoticeListDto> deleteNotice(@PathVariable Long id) {
        noticeService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
