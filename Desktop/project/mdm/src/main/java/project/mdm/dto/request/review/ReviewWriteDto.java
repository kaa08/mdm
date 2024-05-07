package project.mdm.dto.request.review;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.mdm.entity.Review;

@Getter
@Setter
@NoArgsConstructor
public class ReviewWriteDto {

    private String title;
    private String content;

    public ReviewWriteDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Builder
    public static Review ofEntity(ReviewWriteDto dto) {
        return Review.builder()
                .title(dto.title)
                .content(dto.content)
                .build();
    }


}
