package project.mdm.service;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import project.mdm.common.exception.ResourceNotFoundException;
import project.mdm.dto.response.video.ResVideoDownloadDto;
import project.mdm.dto.response.video.ResVideoUploadDto;
import project.mdm.entity.Video;
import project.mdm.repository.VideoRepository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class VideoService {

    private final VideoRepository videoRepository;

    @Value("${project.videoPath}")
    private String VIDEOS_PATH;

    // 측정하기 - 비디오 업로드(디텍션 영상)
    public List<ResVideoUploadDto> upload(List<MultipartFile> multipartFiles) throws IOException {

        List<Video> videoEntities = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFiles) {
            // get origin file name
            String fileName = multipartFile.getOriginalFilename();

            // random name generation of image while uploading to store in folder
            String randomId = UUID.randomUUID().toString();

            // create save File name : ex) POST_randomID.확장자
            String filePath =
                    "POST_" +  randomId.concat(fileName.substring(fileName.indexOf(".")));
            // File.separator : OS에 따른 구분자
            String fileResourcePath = VIDEOS_PATH + File.separator + filePath;

            // create folder if not created
            File f = new File(VIDEOS_PATH);
            if (!f.exists()) {
                f.mkdir();
            }

            // file copy in folder
            Files.copy(multipartFile.getInputStream(), Paths.get(fileResourcePath));

            // create File Entity & 연관관게 매핑
            Video saveVideo = Video.builder()
                    .originFileName(multipartFile.getOriginalFilename())
                    .filePath(filePath)
                    // .fileType(multipartFile.getContentType())
                    .fileType("video/mp4")
                    .build();
            // File Entity 저장 및 DTO로 변환 전송

            videoEntities.add(videoRepository.save(saveVideo));
        }
        List<ResVideoUploadDto> dtos = videoEntities.stream()
                .map(ResVideoUploadDto::fromEntity)
                .collect(Collectors.toList());

        return dtos;
    }
    // 측정하기 - 비디오 다운로드(디텍션 영상)
    public ResVideoDownloadDto download(Long videoId) throws IOException {
        Video video = videoRepository.findById(videoId).orElseThrow(
                () -> new FileNotFoundException()
        );
        String filePath = VIDEOS_PATH + video.getFilePath();
        String contentType = determineContentType(video.getFileType());
        byte[] content = Files.readAllBytes(new File(filePath).toPath());
        return ResVideoDownloadDto.fromVideoResource(video, contentType, content);
    }

    public void delete(Long videoId) {
        Video video = videoRepository.findById(videoId).orElseThrow(
                () -> new ResourceNotFoundException("Video", "Video Id", String.valueOf(videoId))
        );

        // local 파일을 삭제
        String filePath = VIDEOS_PATH + File.separator + video.getFilePath();
        File physicalFile = new File(filePath);
        if (physicalFile.exists()) {
            physicalFile.delete();
        }
        videoRepository.delete(video);
    }

    // 파일 타입 구분
    private String determineContentType(String contentType) {
        // ContentType에 따라 MediaType 결정
        switch (contentType) {
            case "image/png":
                return MediaType.IMAGE_PNG_VALUE;
            case "image/jpeg":
                return MediaType.IMAGE_JPEG_VALUE;
            case "text/plain":
                return MediaType.TEXT_PLAIN_VALUE;
            default:
                return MediaType.APPLICATION_OCTET_STREAM_VALUE;
        }
    }
}
