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

    // 페이징 목록
    @GetMapping("/list")
    public ResponseEntity<Page<ResInquiryListDto>> inquiryList(
            @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<ResInquiryListDto> listDTO = inquiryService.getAllInquiries(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(listDTO);
    }

    // 페이징 검색 , Get 요청 @RequestBody 사용할 수 없음
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

    @PostMapping("/write")
    public ResponseEntity<ResInquiryWriteDto> write(
            @RequestBody InquiryWriteDto inquiryDTO,
            @AuthenticationPrincipal Member member) {
        Thread currentThread = Thread.currentThread();
        log.info("현재 실행 중인 스레드: " + currentThread.getName());
        ResInquiryWriteDto saveInquiryDTO = inquiryService.write(inquiryDTO, member);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveInquiryDTO);
    }

    @GetMapping("/{inquiryId}")
    public ResponseEntity<ResInquiryDetailsDto> detail(@PathVariable("inquiryId") Long inquiryId) {
        ResInquiryDetailsDto findInquiryDTO = inquiryService.detail(inquiryId);
        return ResponseEntity.status(HttpStatus.OK).body(findInquiryDTO);
    }

/*    // 상세보기 -> 수정
    @PatchMapping("/{inquiryId}/update")
    public ResponseEntity<ResInquiryDetailsDto> update(
            @PathVariable Long inquiryId,
            @RequestBody InquiryUpdateDto inquiryDTO) {
        ResInquiryDetailsDto updateInquiryDTO = inquiryService.update(inquiryId, inquiryDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updateInquiryDTO);
    }*/

    // 상세보기 -> 삭제
    @DeleteMapping("/{inquiryId}/delete")
    public ResponseEntity<Long> delete(@PathVariable Long inquiryId) {
        inquiryService.delete(inquiryId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
