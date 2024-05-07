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
    private Integer driveExp;
    private String createdDate;
    private String modifiedDate;

    private List<ResCommentDto> comments;

    @Builder
    public ResReviewDetailsDto(Long reviewID, String title, String content, int viewCount, String writerName, Integer driveExp, String createdDate, String modifiedDate, List<ResCommentDto> comments) {
        this.reviewID = reviewID;
        this.title = title;
        this.content = content;
        this.viewCount = viewCount;
        this.writerName = writerName;
        this.driveExp = driveExp;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.comments = comments;
    }

    public static ResReviewDetailsDto fromEntity(Review review) {
        return ResReviewDetailsDto.builder()
                .reviewID(review.getId())
                .title(review.getTitle())
                .content(review.getContent())
                .viewCount(review.getViewCount())
                .writerName(review.getMember().getUsername())
                .driveExp(review.getMember().getDriveExp())
                .createdDate(review.getCreatedDate())
                .modifiedDate(review.getModifiedDate())
                .comments(review.getComments().stream()
                        .map(ResCommentDto::fromEntity)
                        .collect(Collectors.toList()))
                .build();
    }
}
