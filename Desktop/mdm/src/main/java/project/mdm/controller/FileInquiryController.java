package project.mdm.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project.mdm.dto.response.file.ResFileDownloadDto;
import project.mdm.dto.response.file.ResFileUploadDto;
import project.mdm.service.FileService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/inquiry/{inquiryId}/file")
@RequiredArgsConstructor
public class FileInquiryController {

    private final FileService fileService;

    // 문의하기 - 파일 업로드
    @PostMapping("/upload")
    public ResponseEntity<List<ResFileUploadDto>> upload (
            @PathVariable Long inquiryId,
            @RequestParam("file") List<MultipartFile> files) throws IOException {
        List<ResFileUploadDto> saveFile = fileService.upload(inquiryId, files);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveFile);
    }

    // 문의하기 - 파일 다운로드
    @GetMapping("/download")
    public ResponseEntity<Resource> download (
            @RequestParam("fileId") Long fileId) throws IOException {
        ResFileDownloadDto downloadDto = fileService.download(fileId);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.parseMediaType(downloadDto.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName=\"" + downloadDto.getFilename() + "\"")
                .body(new ByteArrayResource(downloadDto.getContent()));
    }

    // 문의하기 - 파일 삭제
    @DeleteMapping("/delete")
    public ResponseEntity<Long> delete (
            @RequestParam("fileId") Long fileId) {
        fileService.delete(fileId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
