package project.mdm.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;
import org.springframework.format.annotation.DateTimeFormat;
import project.mdm.common.BaseTimeEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Inquiry extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Inquiry_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;


    // 문의 유형
    @Enumerated(EnumType.STRING)
    private InquiryType inquiryType;

    private String title;

    // 문의 내용
    @Column(length = 1000)
    private String contents;

    // 첨부파일
    @OneToMany(mappedBy = "inquiry", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @BatchSize(size = 10)
    private List<FileEntity> files = new ArrayList<>();

    // 답변 여부
    private Boolean replied;

    @Column(length = 1000)
    private String answer;

    @Builder
    public Inquiry(Member member, LocalDate date, InquiryType inquiryType, String title, String contents, Boolean replied, String answer) {
        this.member = member;
        this.inquiryType = inquiryType;
        this.title = title;
        this.contents = contents;
        this.replied = false;
        this.answer = answer;
    }

    public void setMappingMember(Member member) {
        this.member = member;
        member.getInquiries().add(this);
    }

    public void writeAnswer(String answer) {
        this.replied = true;
        this.answer = answer;
    }

}
