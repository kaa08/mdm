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
import project.mdm.entity.Board;
import project.mdm.entity.FileEntity;
import project.mdm.entity.Inquiry;
import project.mdm.repository.BoardRepository;
import project.mdm.repository.FileRepository;
import project.mdm.repository.InquiryRepository;

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
public class FileService {

    private final BoardRepository boardRepository;
    private final InquiryRepository inquiryRepository;
    private final FileRepository fileRepository;

    @Value("${project.folderPath}")
    private String FOLDER_PATH;

    // 커뮤니티 - 커뮤니티 파일 업로드
    public List<ResFileUploadDto> upload(Long boardId, List<MultipartFile> multipartFiles) throws IOException {
        // 게시글 찾기
        Board board = boardRepository.findById(boardId).orElseThrow(
                () -> new ResourceNotFoundException("Board", "Board Id", String.valueOf(boardId))
        );
        List<FileEntity> fileEntitys = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFiles) {
            // get origin file name
            String fileName = multipartFile.getOriginalFilename();

            // random name generation of image while uploading to store in folder
            String randomId = UUID.randomUUID().toString();

            // create save File name : ex) POST_boardID_randomID.확장자
            String filePath =
                    "POST_" + board.getId() + "_" + randomId.concat(fileName.substring(fileName.indexOf(".")));

            // File.separator : OS에 따른 구분자
            String fileResourcePath = FOLDER_PATH + File.separator + filePath;

            // create folder if not created
            File f = new File(FOLDER_PATH);
            if (!f.exists()) {
                f.mkdir();
            }

            // file copy in folder
            Files.copy(multipartFile.getInputStream(), Paths.get(fileResourcePath));

            // create File Entity & 연관관게 매핑
            FileEntity saveFile = FileEntity.builder()
                    .originFileName(multipartFile.getOriginalFilename())
                    .filePath(filePath)
                    .fileType(multipartFile.getContentType())
                    .build();
            saveFile.setMappingBoard(board);
            // File Entity 저장 및 DTO로 변환 전송

            fileEntitys.add(fileRepository.save(saveFile));
        }
        List<ResFileUploadDto> dtos = fileEntitys.stream()
                .map(ResFileUploadDto::fromEntity)
                .collect(Collectors.toList());

        return dtos;
    }

    // 문의하기 - 문의하기 파일 업로드
    public List<ResFileUploadDto> uploadInquiry(Long inquiryId, List<MultipartFile> multipartFiles) throws IOException {
        // 문의하기 찾기
        Inquiry inquiry = inquiryRepository.findById(inquiryId).orElseThrow(
                () -> new ResourceNotFoundException("Inquiry", "Inquiry Id", String.valueOf(inquiryId))
        );
        List<FileEntity> fileEntities = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFiles) {
            // get origin file name
            String fileName = multipartFile.getOriginalFilename();

            // random name generation of image while uploading to store in folder
            String randomId = UUID.randomUUID().toString();

            // create save File name : ex) POST_boardID_randomID.확장자
            String filePath =
                    "POST_" + inquiry.getId() + "_" + randomId.concat(fileName.substring(fileName.indexOf(".")));

            // File.separator : OS에 따른 구분자
            String fileResourcePath = FOLDER_PATH + File.separator + filePath;

            // create folder if not created
            File f = new File(FOLDER_PATH);
            if (!f.exists()) {
                f.mkdir();
            }

            // file copy in folder
            Files.copy(multipartFile.getInputStream(), Paths.get(fileResourcePath));

            // create File Entity & 연관관게 매핑
            FileEntity saveFile = FileEntity.builder()
                    .originFileName(multipartFile.getOriginalFilename())
                    .filePath(filePath)
                    .fileType(multipartFile.getContentType())
                    .build();
            saveFile.setMappingInquiry(inquiry);
            // File Entity 저장 및 DTO로 변환 전송

            fileEntities.add(fileRepository.save(saveFile));
        }
        List<ResFileUploadDto> dtos = fileEntities.stream()
                .map(ResFileUploadDto::fromEntity)
                .collect(Collectors.toList());

        return dtos;
    }

    // 커뮤니티 - 커뮤니티 파일 다운로드
    public ResFileDownloadDto download(Long fileId) throws IOException {
        FileEntity file = fileRepository.findById(fileId).orElseThrow(
                () -> new FileNotFoundException()
        );
        String filePath = FOLDER_PATH + file.getFilePath();
        String contentType = determineContentType(file.getFileType());
        byte[] content = Files.readAllBytes(new File(filePath).toPath());
        return ResFileDownloadDto.fromFileResource(file, content, contentType);
    }

    // 커뮤니티 - 커뮤니티 파일 삭제
    public void delete(Long fileId) {
        FileEntity file = fileRepository.findById(fileId).orElseThrow(
                () -> new ResourceNotFoundException("File", "File Id", String.valueOf(fileId))
        );

        // local 파일을 삭제
        String filePath = FOLDER_PATH + File.separator + file.getFilePath();
        File physicalFile = new File(filePath);
        if (physicalFile.exists()) {
            physicalFile.delete();
        }
        fileRepository.delete(file);
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
