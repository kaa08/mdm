package project.mdm.dto.response.video;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.mdm.entity.Video;

@Getter
@Setter
@NoArgsConstructor
public class ResVideoUploadDto {

    private Long videoId;
    private String originFileName;
    private String filePath;
    private String fileType;

    @Builder
    public ResVideoUploadDto(Long videoId, String originFileName, String filePath, String fileType) {
        this.videoId = videoId;
        this.originFileName = originFileName;
        this.filePath = filePath;
        this.fileType = fileType;
    }

    public static ResVideoUploadDto fromEntity(Video video) {
        return ResVideoUploadDto.builder()
                .videoId(video.getId())
                .originFileName(video.getOriginFileName())
                .filePath(video.getFilePath())
                .fileType(video.getFileType())
                .build();
    }
}
