package project.mdm.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VIDEO_ID")
    private Long id;
    //비디오 이름
    private String name;

    private String filePath;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "video")
    private Review review;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;


    // 넣어야하나 고민... history에는 넣었음..
    /*
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "video")
    private History history;
    */

    @Builder
    public Video(Long id, String name, String filePath) {
        this.id = id;
        this.name = name;
        this.filePath = filePath;
    }
// 과실비율 측정했다고 꼭 리뷰를 써야하는건 아니니까 ...
    /*
    public void setMappingReview(Review review) {
        this.review = review;
    }
    */
}
