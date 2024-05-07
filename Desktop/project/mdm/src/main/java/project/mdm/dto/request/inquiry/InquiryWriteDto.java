package project.mdm.dto.request.inquiry;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.mdm.entity.Board;
import project.mdm.entity.Inquiry;

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

    public InquiryWriteDto(String title, String content) {
        this.title = title;
        this.contents = content;
    }

    @Builder
    public static Inquiry ofEntity(InquiryWriteDto dto) {
        return Inquiry.builder()
                .title(dto.title)
                .contents(dto.contents)
                .build();
    }
}
