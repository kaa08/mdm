package project.mdm.dto.response.history;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.mdm.dto.response.video.ResVideoUploadDto;
import project.mdm.entity.History;
import project.mdm.entity.Video;

@Getter
@Setter
@NoArgsConstructor
public class ResHistoryUploadDto {

    private Long historyId;
    private String originFileName;
    private String filePath;
    private String fileType;
    private String negligence;

    @Builder
    public ResHistoryUploadDto(Long historyId, String originFileName, String filePath, String fileType, String negligence) {
        this.historyId = historyId;
        this.originFileName = originFileName;
        this.filePath = filePath;
        this.fileType = fileType;
        this.negligence = negligence;
    }
    public static ResHistoryUploadDto fromEntity(History history) {
        return ResHistoryUploadDto.builder()
                .historyId(history.getId())
                .originFileName(history.getOriginFileName())
                .filePath(history.getFilePath())
                .fileType(history.getFileType())
                .negligence(history.getNegligence())
                .build();
    }

}
