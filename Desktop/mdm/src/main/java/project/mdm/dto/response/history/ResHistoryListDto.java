package project.mdm.dto.response.history;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.mdm.entity.History;

@Getter
@Setter
@NoArgsConstructor
public class ResHistoryListDto {

    private Long historyId;
    private String negligence;
    private String createdDate;
    private String modifiedDate;

    @Builder
    public ResHistoryListDto(Long historyId, String negligence, String createdDate, String modifiedDate) {
        this.historyId = historyId;
        this.negligence = negligence;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public static ResHistoryListDto fromEntity(History history) {
        return ResHistoryListDto.builder()
                .historyId(history.getId())
                .negligence(history.getNegligence())
                .createdDate(history.getCreatedDate())
                .modifiedDate(history.getModifiedDate())
                .build();
    }

}
