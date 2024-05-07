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
    private Integer driveExp;
    private String createdDate;

    @Builder
    public ResReviewWriteDto(Long reviewId, String title, String content, String writerName, Integer driveExp, String createdDate) {
        this.reviewId = reviewId;
        this.title = title;
        this.content = content;
        this.writerName = writerName;
        this.driveExp = driveExp;
        this.createdDate = createdDate;
    }

    public static ResReviewWriteDto fromEntity(Review review, String writerName, Integer driveExp) {
        return ResReviewWriteDto.builder()
                .reviewId(review.getId())
                .title(review.getTitle())
                .content(review.getContent())
                .writerName(writerName)
                .driveExp(driveExp)
                .createdDate(review.getCreatedDate())
                .build();
    }
}
