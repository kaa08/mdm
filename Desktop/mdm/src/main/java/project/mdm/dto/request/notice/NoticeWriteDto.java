package project.mdm.dto.request.notice;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.mdm.entity.Notice;

@Getter
@Setter
@NoArgsConstructor
public class NoticeWriteDto {

    private String title;
    private String content;

    public NoticeWriteDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Builder
    public static Notice ofEntity(NoticeWriteDto dto) {
        return Notice.builder()
                .title(dto.title)
                .content(dto.content)
                .build();
    }

}
