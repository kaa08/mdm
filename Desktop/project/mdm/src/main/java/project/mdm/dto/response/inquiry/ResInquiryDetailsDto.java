package project.mdm.dto.response.inquiry;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.mdm.dto.response.board.ResBoardDetailsDto;
import project.mdm.dto.response.comment.ResCommentDto;
import project.mdm.dto.response.file.ResBoardDetailsFileDto;
import project.mdm.dto.response.file.ResInquiryDetailsFileDto;
import project.mdm.entity.Board;
import project.mdm.entity.Inquiry;
import project.mdm.entity.InquiryType;
import project.mdm.entity.Member;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * -Response-
 * 게시글 상세, 수정 요청에 대한 정보를 반환
 */

@Getter
@Setter
@NoArgsConstructor
public class ResInquiryDetailsDto {

    // inquiry info
    private Long inquiryId;
    private Member member;
    private LocalDate date;
    private InquiryType inquiryType;
    private String title;
    private String contents;
    private String writerName;
    private boolean replied;
    private String answer;
    // file
    private List<ResInquiryDetailsFileDto> files;

    @Builder
    public ResInquiryDetailsDto(Long inquiryId, Member member, LocalDate date, InquiryType inquiryType, String title, String contents, String writerName, boolean replied, String answer, List<ResInquiryDetailsFileDto> files) {
        this.inquiryId = inquiryId;
        this.member = member;
        this.date = date;
        this.inquiryType = inquiryType;
        this.title = title;
        this.contents = contents;
        this.writerName = writerName;
        this.replied = replied;
        this.answer = answer;
        this.files = files;
    }

    public static ResInquiryDetailsDto fromEntity(Inquiry inquiry) {
        return ResInquiryDetailsDto.builder()
                .inquiryId(inquiry.getId())
                .date(inquiry.getDate())
                .title(inquiry.getTitle())
                .contents(inquiry.getContents())
                .writerName(inquiry.getMember().getUsername())
                .files(inquiry.getFiles().stream()
                        .map(ResInquiryDetailsFileDto::fromEntity)
                        .collect(Collectors.toList()))
                .build();
    }

}
