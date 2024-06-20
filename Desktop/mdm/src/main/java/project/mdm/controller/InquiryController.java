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
import project.mdm.dto.request.board.BoardUpdateDto;
import project.mdm.dto.request.board.BoardWriteDto;
import project.mdm.dto.request.board.SearchData;
import project.mdm.dto.request.inquiry.InquiryUpdateDto;
import project.mdm.dto.request.inquiry.InquiryWriteDto;
import project.mdm.dto.response.board.ResBoardDetailsDto;
import project.mdm.dto.response.board.ResBoardListDto;
import project.mdm.dto.response.board.ResBoardWriteDto;
import project.mdm.dto.response.inquiry.ResInquiryDetailsDto;
import project.mdm.dto.response.inquiry.ResInquiryListDto;
import project.mdm.dto.response.inquiry.ResInquiryWriteDto;
import project.mdm.entity.Member;
import project.mdm.service.InquiryService;

@RestController
@RequestMapping("/inquiry")
@RequiredArgsConstructor
@Slf4j
public class InquiryController {

    private final InquiryService inquiryService;

    // 문의하기 - 전체 목록 조회, 페이징 처리
    @GetMapping("/list")
    public ResponseEntity<Page<ResInquiryListDto>> inquiryList(
            @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<ResInquiryListDto> listDTO = inquiryService.getAllInquiries(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(listDTO);
    }

    // 문의하기 - 게시글 제목, 내용, 작성자별로 검색, 페이징 처리
    @GetMapping("/search")
    public ResponseEntity<Page<ResInquiryListDto>> search(
            @PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
            @RequestParam String title,
            @RequestParam String content,
            @RequestParam String writerName) {
        SearchData searchData = SearchData.createdSearchData(title, content, writerName);
        Page<ResInquiryListDto> searchInquiry = inquiryService.search(searchData, pageable);
        return  ResponseEntity.status(HttpStatus.OK).body(searchInquiry);
    }

    // 문의하기 - 문의하기 작성
    @PostMapping("/write")
    public ResponseEntity<ResInquiryWriteDto> write(
            @RequestBody InquiryWriteDto inquiryDTO,
            @AuthenticationPrincipal Member member) {
        Thread currentThread = Thread.currentThread();
        log.info("현재 실행 중인 스레드: " + currentThread.getName());
        ResInquiryWriteDto saveInquiryDTO = inquiryService.write(inquiryDTO, member);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveInquiryDTO);
    }

    // 문의하기 - 문의하기 글 조회
    @GetMapping("/{inquiryId}")
    public ResponseEntity<ResInquiryDetailsDto> detail(@PathVariable("inquiryId") Long inquiryId) {
        ResInquiryDetailsDto findInquiryDTO = inquiryService.detail(inquiryId);
        return ResponseEntity.status(HttpStatus.OK).body(findInquiryDTO);
    }

    // 문의하기 - 문의하기 글 상세보기 후, 삭제
    @DeleteMapping("/{inquiryId}/delete")
    public ResponseEntity<Long> delete(@PathVariable Long inquiryId) {
        inquiryService.delete(inquiryId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
