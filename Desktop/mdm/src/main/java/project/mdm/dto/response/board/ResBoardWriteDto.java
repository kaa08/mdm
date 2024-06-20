package project.mdm.dto.response.board;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.mdm.entity.Board;

/**
 * -Response-
 * 게시글 등록 반환 정보
 */

@Getter
@Setter
@NoArgsConstructor
public class ResBoardWriteDto {

    private Long boardId;
    private String title;
    private String content;
    private String writerName;
    private String writerEmail;
    private Integer driveExp;
    private String createdDate;

    @Builder
    public ResBoardWriteDto(Long boardId, String title, String content, String writerName, String writerEmail, Integer driveExp, String createdDate) {
        this.boardId = boardId;
        this.title = title;
        this.content = content;
        this.writerName = writerName;
        this.writerEmail = writerEmail;
        this.driveExp = driveExp;
        this.createdDate = createdDate;
    }

    public static ResBoardWriteDto fromEntity(Board board, String writerName, String writerEmail, Integer driveExp) {
        return ResBoardWriteDto.builder()
                .boardId(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .writerName(writerName)
                .writerEmail(writerEmail)
                .driveExp(driveExp)
                .createdDate(board.getCreatedDate())
                .build();
    }
}
