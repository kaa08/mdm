package project.mdm.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project.mdm.dto.response.history.ResHistoryDownloadDto;
import project.mdm.dto.response.history.ResHistoryUploadDto;
import project.mdm.dto.response.video.ResVideoDownloadDto;
import project.mdm.dto.response.video.ResVideoUploadDto;
import project.mdm.entity.Member;
import project.mdm.service.HistoryService;
import project.mdm.service.VideoService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/history")
@RequiredArgsConstructor
@Slf4j
public class HistoryController {

    private final HistoryService historyService;

    // 과거 기록 - 교통사고 영상 업로드
    @PostMapping("/upload")
    public ResponseEntity<List<ResHistoryUploadDto>> upload(
            @RequestParam("file") List<MultipartFile> videos,
            @RequestParam("ratio") String negligence,
            @AuthenticationPrincipal Member member
    ) throws IOException {
        List<ResHistoryUploadDto> saveHistory = historyService.upload(videos, negligence, member);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveHistory);
    }

    // 과거 기록 - 교통사고 영상 다운로드
    @GetMapping("/download")
    public ResponseEntity<Resource> download(
            @RequestParam("historyId") Long historyId) throws IOException {
        ResHistoryDownloadDto downloadDto = historyService.download(historyId);

        return ResponseEntity.status(HttpStatus.OK)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName=\"" + downloadDto.getVideoName() + "\"")
                .body(new ByteArrayResource(downloadDto.getContent()));
    }

    // 과거기록 - 과거 기록 삭제
    @DeleteMapping("/delete")
    public ResponseEntity<Long> delete(
            @RequestParam("historyId") Long historyId) {
        historyService.delete(historyId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}

