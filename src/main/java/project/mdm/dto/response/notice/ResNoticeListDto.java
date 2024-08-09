package project.mdm.dto.response.notice;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.mdm.entity.Notice;

@Getter
@Setter
@NoArgsConstructor
public class ResNoticeListDto {
    private Long noticeId;
    private String title;
    private String content;
    private int viewCount;
    private String createdDate;
    private String modifiedDate;
    private String writerName;

    @Builder
    public ResNoticeListDto(Long noticeId, String title, String content, int viewCount, String createdDate, String modifiedDate, String writerName) {
        this.noticeId = noticeId;
        this.title = title;
        this.content = content;
        this.viewCount = viewCount;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.writerName = writerName;
    }

    public static ResNoticeListDto fromEntity(Notice notice) {
        return ResNoticeListDto.builder()
                .noticeId(notice.getId())
                .title(notice.getTitle())
                .content(notice.getContent())
                .viewCount(notice.getViewCount())
                .createdDate(notice.getCreatedDate())
                .modifiedDate(notice.getModifiedDate())
                .writerName(notice.getMember().getNickname())
                .build();
    }
}
