package project.mdm.dto.request.comment;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.mdm.entity.Comment;

/**
 * -Request-
 * 댓글 등록, 수정 요청, <br>
 * -Member, Board는 URI Resource로 받음
 */

@Getter
@Setter
@NoArgsConstructor
public class CommentDto {

    private String content;

    @Builder
    public CommentDto(String content) {
        this.content = content;
    }

    public static Comment ofEntity(CommentDto dto) {
        return Comment.builder()
                .content(dto.getContent())
                .build();
    }
}
