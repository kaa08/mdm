package project.mdm.dto.response.review;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.mdm.dto.response.comment.ResCommentDto;
import project.mdm.entity.Review;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class ResReviewDetailsDto {

    private Long reviewID;
    private String title;
    private String content;
    private int viewCount;
    private String writerName;
    private String writerEmail;
    private Integer driveExp;
    private String createdDate;
    private String modifiedDate;
    private Long historyId;
    private String negligence;


    @Builder
    public ResReviewDetailsDto(Long reviewID, String title, String content, int viewCount, String writerName, String writerEmail, Integer driveExp, String createdDate, String modifiedDate, Long historyId, String negligence) {
        this.reviewID = reviewID;
        this.title = title;
        this.content = content;
        this.viewCount = viewCount;
        this.writerName = writerName;
        this.writerEmail = writerEmail;
        this.driveExp = driveExp;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.historyId = historyId;
        this.negligence = negligence;
    }

    public static ResReviewDetailsDto fromEntity(Review review) {
        return ResReviewDetailsDto.builder()
                .reviewID(review.getId())
                .title(review.getTitle())
                .content(review.getContent())
                .viewCount(review.getViewCount())
                .writerName(review.getMember().getNickname())
                .writerEmail(review.getMember().getUsername())
                .driveExp(review.getMember().getDriveExp())
                .createdDate(review.getCreatedDate())
                .modifiedDate(review.getModifiedDate())
                .historyId(review.getHistory().getId())
                .negligence(review.getHistory().getNegligence())
                .build();
    }
}
