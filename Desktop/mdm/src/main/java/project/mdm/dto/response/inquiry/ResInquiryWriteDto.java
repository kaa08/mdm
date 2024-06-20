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
    private String answer;
    private String writerName;
    private String writerEmail;
    private String createdDate;

    @Builder
    public ResInquiryWriteDto(Long inquiryId, String title, String contents, String answer, String writerName, String writerEmail, String createdDate) {
        this.inquiryId = inquiryId;
        this.title = title;
        this.contents = contents;
        this.answer = answer;
        this.writerName = writerName;
        this.writerEmail = writerEmail;
        this.createdDate = createdDate;
    }

    public static ResInquiryWriteDto fromEntity(Inquiry inquiry, String writerName, String writerEmail) {
        return ResInquiryWriteDto.builder()
                .inquiryId(inquiry.getId())
                .title(inquiry.getTitle())
                .contents(inquiry.getContents())
                .answer(inquiry.getAnswer())
                .writerName(writerName)
                .writerEmail(writerEmail)
                .createdDate(inquiry.getCreatedDate())
                .build();
    }
}
