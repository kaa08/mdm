package project.mdm.dto.response.notice;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.mdm.entity.Notice;

@Getter
@Setter
@NoArgsConstructor
public class ResNoticeDetailsDto {

    private Long noticeID;
    private String title;
    private String content;
    private int viewCount;
    private String writerName;
    private String createdDate;
    private String modifiedDate;

    @Builder
    public ResNoticeDetailsDto(String modifiedDate, String createdDate, String writerName, int viewCount, String content, String title, Long noticeID) {
        this.modifiedDate = modifiedDate;
        this.createdDate = createdDate;
        this.writerName = writerName;
        this.viewCount = viewCount;
        this.content = content;
        this.title = title;
        this.noticeID = noticeID;
    }

    public static ResNoticeDetailsDto fromEntity(Notice notice) {
        return ResNoticeDetailsDto.builder()
                .noticeID(notice.getId())
                .title(notice.getTitle())
                .content(notice.getContent())
                .viewCount(notice.getViewCount())
                .writerName(notice.getMember().getNickname())
                .createdDate(notice.getCreatedDate())
                .modifiedDate(notice.getModifiedDate())
                .build();
    }

}
