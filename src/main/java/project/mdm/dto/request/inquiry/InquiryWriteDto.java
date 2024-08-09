package project.mdm.dto.request.inquiry;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.mdm.entity.Board;
import project.mdm.entity.Inquiry;
import project.mdm.entity.InquiryType;

/**
 * -Request-
 * 게시글 등록 정보 요청, 작성자는 Authentication 받음
 */

@Getter
@Setter
@NoArgsConstructor
public class InquiryWriteDto {

    private String title;
    private String contents;
    private String answer;
    private InquiryType inquiryType;

    @Builder
    public InquiryWriteDto(String title, String contents, String answer, InquiryType inquiryType) {
        this.title = title;
        this.contents = contents;
        this.answer = answer;
        this.inquiryType = inquiryType;
    }


    public static Inquiry ofEntity(InquiryWriteDto dto) {
        return Inquiry.builder()
                .title(dto.title)
                .contents(dto.contents)
                .answer(dto.getAnswer())
                .inquiryType(dto.getInquiryType())
                .build();
    }
}
