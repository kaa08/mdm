package project.mdm.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import project.mdm.common.exception.ResourceNotFoundException;
import project.mdm.dto.response.file.ResFileDownloadDto;
import project.mdm.dto.response.file.ResFileUploadDto;
import project.mdm.dto.response.video.ResVideoDownloadDto;
import project.mdm.dto.response.video.ResVideoUploadDto;
import project.mdm.entity.Board;
import project.mdm.entity.FileEntity;
import project.mdm.entity.Video;
import project.mdm.repository.VideoRepository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class VideoService {

    private final VideoRepository videoRepository;

    @Value("videos/")
    private String VIDEOS_PATH;

    public List<ResVideoUploadDto> upload(List<MultipartFile> multipartFiles) throws IOException {

        List<Video> videoEntities = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFiles) {
            // get origin file name
            String fileName = multipartFile.getOriginalFilename();

            // random name generation of image while uploading to store in folder
            String randomId = UUID.randomUUID().toString();

            // create save File name : ex) POST_boardID_randomID.확장자
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
                    .name(multipartFile.getOriginalFilename())
                    .filePath(filePath)
                    .build();
            // File Entity 저장 및 DTO로 변환 전송

            videoEntities.add(videoRepository.save(saveVideo));
        }
        List<ResVideoUploadDto> dtos = videoEntities.stream()
                .map(ResVideoUploadDto::fromEntity)
                .collect(Collectors.toList());

        return dtos;
    }

    public ResVideoDownloadDto download(Long videoId) throws IOException {
        Video video = videoRepository.findById(videoId).orElseThrow(
                () -> new FileNotFoundException()
        );
        String filePath = VIDEOS_PATH + video.getFilePath();
        byte[] content = Files.readAllBytes(new File(filePath).toPath());
        return ResVideoDownloadDto.fromVideoResource(video, content);
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
}
