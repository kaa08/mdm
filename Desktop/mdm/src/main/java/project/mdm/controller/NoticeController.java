package project.mdm.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.mdm.dto.request.board.SearchData;
import project.mdm.dto.response.notice.ResNoticeDetailsDto;
import project.mdm.dto.response.notice.ResNoticeListDto;
import project.mdm.service.NoticeService;

@RestController
@RequestMapping("/notice")
@RequiredArgsConstructor
@Slf4j
public class NoticeController {

    private final NoticeService noticeService;

    // 공지사항 - 공지사항 목록 조회, 페이징 처리
    @GetMapping("/list")
    public ResponseEntity<Page<ResNoticeListDto>> noticeList(
            @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<ResNoticeListDto> listDTO = noticeService.getAllNotices(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(listDTO);
    }

    // 공지사항 - 공지사항 제목, 내용, 작성자별로 검색, 페이징 처리
    @GetMapping("/search")
    public ResponseEntity<Page<ResNoticeListDto>> search(
            @PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
            @RequestParam String title,
            @RequestParam String content,
            @RequestParam String writerName) {
        SearchData searchData = SearchData.createdSearchData(title, content, writerName);
        Page<ResNoticeListDto> searchNotice = noticeService.search(searchData, pageable);
        return  ResponseEntity.status(HttpStatus.OK).body(searchNotice);
    }

    // 공지사항 - 공지사항 조회
    @GetMapping("/{noticeId}")
    public ResponseEntity<ResNoticeDetailsDto> detail(@PathVariable("noticeId") Long noticeId) {
        ResNoticeDetailsDto findNoticeDTO = noticeService.detail(noticeId);
        return ResponseEntity.status(HttpStatus.OK).body(findNoticeDTO);
    }

}
