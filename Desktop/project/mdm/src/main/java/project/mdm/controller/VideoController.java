package project.mdm.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project.mdm.dto.request.board.BoardUpdateDto;
import project.mdm.dto.request.board.BoardWriteDto;
import project.mdm.dto.request.board.SearchData;
import project.mdm.dto.response.board.ResBoardDetailsDto;
import project.mdm.dto.response.board.ResBoardListDto;
import project.mdm.dto.response.board.ResBoardWriteDto;
import project.mdm.dto.response.file.ResFileDownloadDto;
import project.mdm.dto.response.video.ResVideoDownloadDto;
import project.mdm.dto.response.video.ResVideoUploadDto;
import project.mdm.entity.Member;
import project.mdm.service.VideoService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/video")
@RequiredArgsConstructor
@Slf4j
public class VideoController {

    private final VideoService videoService;

    @PostMapping("/upload")
    public ResponseEntity<List<ResVideoUploadDto>> upload(
            @RequestParam("video") List<MultipartFile> videos
    ) throws IOException {
        List<ResVideoUploadDto> saveVideo = videoService.upload(videos);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveVideo);
    }


    @GetMapping("/download")
    public ResponseEntity<Resource> download (
            @RequestParam("videoId") Long videoId) throws IOException {
        ResVideoDownloadDto downloadDto = videoService.download(videoId);

        return ResponseEntity.status(HttpStatus.OK)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName=\"" + downloadDto.getName() + "\"")
                .body(new ByteArrayResource(downloadDto.getContent()));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Long> delete (
            @RequestParam("videoId") Long videoId) {
        videoService.delete(videoId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
