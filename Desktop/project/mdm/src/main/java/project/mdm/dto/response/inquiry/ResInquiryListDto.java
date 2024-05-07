package project.mdm.dto.response.inquiry;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.mdm.entity.Inquiry;

import java.time.LocalDate;

/**
 * -Response-
 * list 요청에 대한 정보를 반환, 양방향 관계로 인해 JSON 직렬화가 반복되는 문제를 해결하기 위한 DTO
 */

@Getter
@Setter
@NoArgsConstructor
public class ResInquiryListDto {
    // 작성일, 수정일, 작성자, 댓글 개수만 전체 목록에 대한 데이터로 받으면 됨
    // 상세한 댓글 내용 등은 상세보기에서 처리
    private Long inquiryId;
    private LocalDate date;
    private String title;
    private String contents;
    private String writerName;
    private Boolean replied;

    @Builder
    public ResInquiryListDto(Long inquiryId, LocalDate date, String title, String contents, String writerName, Boolean replied) {
        this.inquiryId = inquiryId;
        this.date = date;
        this.title = title;
        this.contents = contents;
        this.writerName = writerName;
        this.replied = replied;
    }

    // Entity -> DTO
    public static ResInquiryListDto fromEntity(Inquiry inquiry) {
        return ResInquiryListDto.builder()
                .inquiryId(inquiry.getId())
                .title(inquiry.getTitle())
                .contents(inquiry.getContents())
                .date(inquiry.getDate())
                .writerName(inquiry.getMember().getUsername())
                .replied(inquiry.getReplied())
                .build();
    }
}
