package project.mdm.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.mdm.common.BaseTimeEntity;

@Entity
@Getter
@NoArgsConstructor
public class History extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer negligenceA;

    private Integer negligenceB;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VIDEO_ID")
    private Video video;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "history")
    private Review review;

    @Builder
    public History(Integer negligenceA, Integer negligenceB) {
        this.negligenceA = negligenceA;
        this.negligenceB = negligenceB;
    }
}
