package project.mdm.dto.response.video;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.mdm.dto.response.file.ResFileDownloadDto;
import project.mdm.entity.Video;

@Getter
@Setter
@NoArgsConstructor
public class ResVideoDownloadDto {

    private String videoName;
    private byte[] content;
    private String fileType;

    @Builder
    public ResVideoDownloadDto(String videoName, byte[] content, String fileType) {
        this.videoName = videoName;
        this.content = content;
        this.fileType = fileType;
    }

    public static ResVideoDownloadDto fromVideoResource(Video video, String contentType, byte[] content) {
        return ResVideoDownloadDto.builder()
                .videoName(video.getOriginFileName())
                .content(content)
                .fileType(contentType)
                // .fileType(video.getFileType())
                .build();
    }
}
