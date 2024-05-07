package project.mdm.dto.response.inquiry;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.mdm.entity.Board;
import project.mdm.entity.Inquiry;

import java.time.LocalDate;

/**
 * -Response-
 * 게시글 등록 반환 정보
 */

@Getter
@Setter
@NoArgsConstructor
public class ResInquiryWriteDto {

    private Long inquiryId;
    private String title;
    private String contents;
    private String writerName;
    private LocalDate date;

    @Builder
    public ResInquiryWriteDto(Long inquiryId, String title, String contents, String writerName, LocalDate date) {
        this.inquiryId = inquiryId;
        this.title = title;
        this.contents = contents;
        this.writerName = writerName;
        this.date = date;
    }

    public static ResInquiryWriteDto fromEntity(Inquiry inquiry, String writerName) {
        return ResInquiryWriteDto.builder()
                .inquiryId(inquiry.getId())
                .title(inquiry.getTitle())
                .contents(inquiry.getContents())
                .writerName(writerName)
                .date(inquiry.getDate())
                .build();
    }
}
