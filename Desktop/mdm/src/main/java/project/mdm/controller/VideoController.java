package project.mdm.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project.mdm.dto.response.video.ResVideoDownloadDto;
import project.mdm.dto.response.video.ResVideoUploadDto;
import project.mdm.service.VideoService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/video")
@RequiredArgsConstructor
@Slf4j
public class VideoController {

    private final VideoService videoService;

    // 측정하기 - 측정한 동영상 업로드(디텍션 된 동영상)
    @PostMapping("/upload")
    public ResponseEntity<List<ResVideoUploadDto>> upload(
            @RequestParam("file") List<MultipartFile> videos
    ) throws IOException {
        List<ResVideoUploadDto> saveVideo = videoService.upload(videos);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveVideo);
    }

    // 측정하기 - 측정한 동영상 다운로드(디텍션 된 동영상)
    @GetMapping("/download")
    public ResponseEntity<Resource> download (
            @RequestParam("videoId") Long videoId) throws IOException {
        ResVideoDownloadDto downloadDto = videoService.download(videoId);

        return ResponseEntity.status(HttpStatus.OK)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName=\"" + downloadDto.getVideoName() + "\"")
                .body(new ByteArrayResource(downloadDto.getContent()));
    }

    // 측정하기 - 측정한 동영상 삭제(디텍션 된 동영상)
    @DeleteMapping("/delete")
    public ResponseEntity<Long> delete (
            @RequestParam("videoId") Long videoId) {
        videoService.delete(videoId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}