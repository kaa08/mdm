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
import project.mdm.dto.request.board.SearchData;
import project.mdm.dto.request.review.ReviewUpdateDto;
import project.mdm.dto.request.review.ReviewWriteDto;
import project.mdm.dto.response.review.ResReviewDetailsDto;
import project.mdm.dto.response.review.ResReviewListDto;
import project.mdm.dto.response.review.ResReviewWriteDto;
import project.mdm.entity.Member;
import project.mdm.service.ReviewService;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
@Slf4j
public class ReviewController {

    private final ReviewService reviewService;

    //리뷰 페이징
    @GetMapping("/list")
    public ResponseEntity<Page<ResReviewListDto>> reviewList(
            @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        Page<ResReviewListDto> listDTO = reviewService.getAllReviews(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(listDTO);
    }

    // 페이징 검색, Get 요청
    @GetMapping("/search")
    public ResponseEntity<Page<ResReviewListDto>> search(
            @PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
            @RequestParam String title,
            @RequestParam String content,
            @RequestParam String writerName
    ) {
        SearchData searchData = SearchData.createdSearchData(title, content, writerName);
        Page<ResReviewListDto> searchReview = reviewService.search(searchData, pageable);
        return ResponseEntity.status(HttpStatus.OK).body(searchReview);
    }

    //후기 작성
    @PostMapping("/write")
    public ResponseEntity<ResReviewWriteDto> write(
            @RequestBody ReviewWriteDto reviewDTO,
            @AuthenticationPrincipal Member member
    ) {
        Thread currentThread = Thread.currentThread();
        log.info("현재 진행 중인 스레드: " + currentThread.getName());
        ResReviewWriteDto saveReviewDTO = reviewService.write(reviewDTO, member);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveReviewDTO);
    }

    //후기 상세 조회
    @GetMapping("/{reviewId}")
    public ResponseEntity<ResReviewDetailsDto> detail(@PathVariable("reviewId") Long reviewId) {
        ResReviewDetailsDto findReviewDTO = reviewService.detail(reviewId);
        return ResponseEntity.status(HttpStatus.OK).body(findReviewDTO);
    }

    //상세조회 -> 수정
    @PatchMapping("/{reviewId}/update")
    public ResponseEntity<ResReviewDetailsDto> update(
            @PathVariable("reviewId") Long reviewId,
            @RequestBody ReviewUpdateDto reviewDTO) {
        ResReviewDetailsDto updateReviewDTO = reviewService.update(reviewId, reviewDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updateReviewDTO);
    }

    // 상세보기 -> 삭제
    @DeleteMapping("/{reviewId}/delete")
    public ResponseEntity<Long> delete(@PathVariable Long reviewId) {
        reviewService.delete(reviewId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
