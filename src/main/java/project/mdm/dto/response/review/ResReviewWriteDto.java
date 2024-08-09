package project.mdm.dto.response.review;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.mdm.dto.response.board.ResBoardWriteDto;
import project.mdm.entity.Board;
import project.mdm.entity.Review;

@Getter
@Setter
@NoArgsConstructor
public class ResReviewWriteDto {

    private Long reviewId;
    private String title;
    private String content;
    private String writerName;
    private String writerEmail;
    private Integer driveExp;
    private String createdDate;
    private Long historyId;
    private String negligence;

    @Builder
    public ResReviewWriteDto(Long reviewId, String title, String content, String writerName, String writerEmail, Integer driveExp, String createdDate, Long historyId, String negligence) {
        this.reviewId = reviewId;
        this.title = title;
        this.content = content;
        this.writerName = writerName;
        this.writerEmail = writerEmail;
        this.driveExp = driveExp;
        this.createdDate = createdDate;
        this.historyId = historyId;
        this.negligence = negligence;
    }

    public static ResReviewWriteDto fromEntity(Review review, String writerName, String writerEmail, Integer driveExp) {
        return ResReviewWriteDto.builder()
                .reviewId(review.getId())
                .title(review.getTitle())
                .content(review.getContent())
                .writerName(writerName)
                .writerEmail(writerEmail)
                .driveExp(driveExp)
                .createdDate(review.getCreatedDate())
                .historyId(review.getHistory().getId())
                .negligence(review.getHistory().getNegligence())
                .build();
    }
}
