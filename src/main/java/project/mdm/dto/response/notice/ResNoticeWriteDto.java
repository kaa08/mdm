package project.mdm.dto.response.notice;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.mdm.entity.Notice;

@Getter
@Setter
@NoArgsConstructor
public class ResNoticeWriteDto {

    private Long noticeId;
    private String title;
    private String content;
    private String writerName;
    private String createdDate;

    @Builder
    public ResNoticeWriteDto(Long noticeId, String title, String content, String writerName, String createdDate) {
        this.noticeId = noticeId;
        this.title = title;
        this.content = content;
        this.writerName = writerName;
        this.createdDate = createdDate;
    }

    public static ResNoticeWriteDto fromEntity(Notice notice, String writerName) {
        return ResNoticeWriteDto.builder()
                .noticeId(notice.getId())
                .title(notice.getTitle())
                .content(notice.getContent())
                .writerName(writerName)
                .createdDate(notice.getCreatedDate())
                .build();
    }

}
