package project.mdm.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import project.mdm.common.exception.ResourceNotFoundException;
import project.mdm.dto.response.history.ResHistoryDownloadDto;
import project.mdm.dto.response.history.ResHistoryListDto;
import project.mdm.dto.response.history.ResHistoryUploadDto;
import project.mdm.dto.response.inquiry.ResInquiryListDto;
import project.mdm.entity.History;
import project.mdm.entity.Inquiry;
import project.mdm.entity.Member;
import project.mdm.repository.HistoryRepository;
import project.mdm.repository.MemberRepository;

import java.io.File;
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
public class HistoryService {

    private final HistoryRepository historyRepository;
    private final MemberRepository memberRepository;

    @Value("${project.originPath}")
    private String ORIGIN_PATH;

    // 과거 기록 - 과거 기록 업로드
    public List<ResHistoryUploadDto> upload(List<MultipartFile> multipartFiles, String negligence, Member member) throws IOException {

        List<History> historyEntities = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFiles) {
            // get origin file name
            String fileName = multipartFile.getOriginalFilename();

            // random name generation of image while uploading to store in folder
            String randomId = UUID.randomUUID().toString();

            // create save File name : ex) POST_randomID.확장자
            String filePath =
                    "POST_" +  randomId.concat(fileName.substring(fileName.indexOf(".")));
            // File.separator : OS에 따른 구분자
            String fileResourcePath = ORIGIN_PATH + File.separator + filePath;

            // create folder if not created
            File f = new File(ORIGIN_PATH);
            if (!f.exists()) {
                f.mkdir();
            }

            // file copy in folder
            Files.copy(multipartFile.getInputStream(), Paths.get(fileResourcePath));

            // create File Entity & 연관관게 매핑
            History saveHistory = History.builder()
                    .originFileName(multipartFile.getOriginalFilename())
                    .filePath(filePath)
                    // .fileType(multipartFile.getContentType())
                    .fileType("video/mp4")
                    .negligence(negligence)
                    .build();

            // 과거기록(동영상, 과실비율) & 사용자 매핑
            Member writerMember = memberRepository.findByEmail(member.getEmail()).orElseThrow(
                    () -> new ResourceNotFoundException("Member", "Member Email", member.getEmail())
            );
            saveHistory.setMappingMember(writerMember);

            // File Entity 저장 및 DTO로 변환 전송
            historyEntities.add(historyRepository.save(saveHistory));
        }
        List<ResHistoryUploadDto> dtos = historyEntities.stream()
                .map(ResHistoryUploadDto::fromEntity)
                .collect(Collectors.toList());
        return dtos;
    }

    // 과거기록 - 과거기록 동영상 다운로드
    public ResHistoryDownloadDto download(Long historyId) throws IOException {
        History history = historyRepository.findById(historyId).orElseThrow(
                () -> new ResourceNotFoundException("History", "History Id", String.valueOf(historyId))
        );
        String filePath = ORIGIN_PATH + history.getFilePath();
        String contentType = determineContentType(history.getFileType());
        byte[] content = Files.readAllBytes(new File(filePath).toPath());
        return ResHistoryDownloadDto.fromVideoResource(history, contentType, content);
    }

    // 마이페이지 - 사용자 별 과거기록 조회
    public Page<ResHistoryListDto> getAllHistoryByMember(Pageable pageable, Member member) {
        Page<History> histories = historyRepository.findAllByMember(member, pageable);
        List<ResHistoryListDto> list = histories.getContent().stream()
                .map(ResHistoryListDto::fromEntity)
                .collect(Collectors.toList());
        return new PageImpl<>(list, pageable, histories.getTotalElements());
    }

    // 과거기록 - 과거기록 삭제
    public void delete(Long historyId) {
        History history = historyRepository.findById(historyId).orElseThrow(
                () -> new ResourceNotFoundException("History", "History Id", String.valueOf(historyId))
        );

        // local 파일을 삭제
        String filePath = ORIGIN_PATH + File.separator + history.getFilePath();
        File physicalFile = new File(filePath);
        if (physicalFile.exists()) {
            physicalFile.delete();
        }
        historyRepository.delete(history);
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
