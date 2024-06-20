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
import project.mdm.dto.response.board.ResBoardDetailsDto;
import project.mdm.dto.response.board.ResBoardListDto;
import project.mdm.dto.response.board.ResBoardWriteDto;
import project.mdm.entity.Member;
import project.mdm.service.BoardService;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardService boardService;

    // 커뮤니티 -  게시글 목록 초회, 페이징
    @GetMapping("/list")
    public ResponseEntity<Page<ResBoardListDto>> boardList(
            @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<ResBoardListDto> listDTO = boardService.getAllBoards(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(listDTO);
    }

    // 커뮤니티 - 게시글 제목, 내용, 작성자별로 검색, 페이징 처리
    @GetMapping("/search")
    public ResponseEntity<Page<ResBoardListDto>> search(
            @PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
            @RequestParam String title,
            @RequestParam String content,
            @RequestParam String writerName) {
        SearchData searchData = SearchData.createdSearchData(title, content, writerName);
        Page<ResBoardListDto> searchBoard = boardService.search(searchData, pageable);
        return  ResponseEntity.status(HttpStatus.OK).body(searchBoard);
    }

    // 커뮤니티 - 게시글 작성
    @PostMapping("/write")
    public ResponseEntity<ResBoardWriteDto> write(
            @RequestBody BoardWriteDto boardDTO,
            @AuthenticationPrincipal Member member) {
        Thread currentThread = Thread.currentThread();
        log.info("현재 실행 중인 스레드: " + currentThread.getName());
        ResBoardWriteDto saveBoardDTO = boardService.write(boardDTO, member);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveBoardDTO);
    }

    // 커뮤니티 - 게시글 조회
    @GetMapping("/{boardId}")
    public ResponseEntity<ResBoardDetailsDto> detail(@PathVariable("boardId") Long boardId) {
        ResBoardDetailsDto findBoardDTO = boardService.detail(boardId);
        return ResponseEntity.status(HttpStatus.OK).body(findBoardDTO);
    }

    // 커뮤니티 - 게시글 상세보기 후, 업데이트
    @PatchMapping("/{boardId}/update")
    public ResponseEntity<ResBoardDetailsDto> update(
            @PathVariable Long boardId,
            @RequestBody BoardUpdateDto boardDTO) {
        ResBoardDetailsDto updateBoardDTO = boardService.update(boardId, boardDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updateBoardDTO);
    }

    // 커뮤니티 - 게시글 상세보기 후 삭제
    @DeleteMapping("/{boardId}/delete")
    public ResponseEntity<Long> delete(@PathVariable Long boardId) {
        boardService.delete(boardId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
