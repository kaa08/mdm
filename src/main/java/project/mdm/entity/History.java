package project.mdm.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.mdm.common.BaseTimeEntity;
import project.mdm.dto.response.history.ResHistoryUploadDto;
import project.mdm.dto.response.video.ResVideoUploadDto;

@Entity
@Getter
@NoArgsConstructor
public class History extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HISTORY_ID")
    private Long id;

    @Column(name = "FILE_TYPE")
    private String fileType;
    //비디오 이름
    private String originFileName;

    private String filePath;

    private String negligence;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

/*    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VIDEO_ID")
    private Video video;*/

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "history")
    private Review review;


    @Builder
    public History(String fileType, String originFileName, String filePath, String negligence) {
        this.fileType = fileType;
        this.originFileName = originFileName;
        this.filePath = filePath;
        this.negligence = negligence;
    }

    public static ResHistoryUploadDto fromEntity(History history) {
        return ResHistoryUploadDto.builder()
                .historyId(history.getId())
                .originFileName(history.getOriginFileName())
                .filePath(history.getFilePath())
                .fileType(history.getFileType())
                .negligence(history.getNegligence())
                .build();
    }

    //== Member & Board 연관관계 편의 메소드 ==//
    public void setMappingMember(Member member) {
        this.member = member;
        member.getHistories().add(this);
    }

    public void setReview(Review review) {
        this.review = review;
    }
}
