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
    private String name;
    private String filePath;

    @Builder
    public ResVideoUploadDto(Long videoId, String name, String filePath) {
        this.videoId = videoId;
        this.name = name;
        this.filePath = filePath;
    }

    public static ResVideoUploadDto fromEntity(Video video) {
        return ResVideoUploadDto.builder()
                .videoId(video.getId())
                .name(video.getName())
                .filePath(video.getFilePath())
                .build();
    }
}
