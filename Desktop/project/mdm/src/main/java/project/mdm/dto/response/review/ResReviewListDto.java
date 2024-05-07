package project.mdm.dto.response.review;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.mdm.dto.response.board.ResBoardListDto;
import project.mdm.entity.Board;
import project.mdm.entity.Review;

@Getter
@Setter
@NoArgsConstructor
public class ResReviewListDto {
    private Long reviewId;
    private String title;
    private String content;
    private int viewCount;
    private String createdDate;
    private String modifiedDate;
    private String writerName;

    @Builder
    public ResReviewListDto(Long reviewId, String title, String content, int viewCount, String createdDate, String modifiedDate, String writerName) {
        this.reviewId = reviewId;
        this.title = title;
        this.content = content;
        this.viewCount = viewCount;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.writerName = writerName;
    }

    public static ResReviewListDto fromEntity(Review review) {
        return ResReviewListDto.builder()
                .reviewId(review.getId())
                .title(review.getTitle())
                .content(review.getContent())
                .viewCount(review.getViewCount())
                .createdDate(review.getCreatedDate())
                .modifiedDate(review.getModifiedDate())
                .writerName(review.getMember().getUsername())
                .build();
    }
}
