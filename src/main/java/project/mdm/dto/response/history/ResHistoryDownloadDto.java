package project.mdm.dto.response.history;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.mdm.entity.History;
import project.mdm.entity.Video;

@Getter
@Setter
@NoArgsConstructor
public class ResHistoryDownloadDto {

    private String videoName;
    private byte[] content;
    private String fileType;

    @Builder
    public ResHistoryDownloadDto(String videoName, byte[] content, String fileType) {
        this.videoName = videoName;
        this.content = content;
        this.fileType = fileType;
    }

    public static ResHistoryDownloadDto fromVideoResource(History history, String contentType, byte[] content) {
        return ResHistoryDownloadDto.builder()
                .videoName(history.getOriginFileName())
                .content(content)
                .fileType(contentType)
                // .fileType(video.getFileType())
                .build();
    }
}
