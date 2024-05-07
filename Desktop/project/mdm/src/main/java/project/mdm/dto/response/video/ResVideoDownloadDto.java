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

    private String name;
    private byte[] content;

    @Builder
    public ResVideoDownloadDto(String name, byte[] content) {
        this.name = name;
        this.content = content;
    }

    public static ResVideoDownloadDto fromVideoResource(Video video, byte[] content) {
        return ResVideoDownloadDto.builder()
                .name(video.getName())
                .content(content)
                .build();
    }
}
