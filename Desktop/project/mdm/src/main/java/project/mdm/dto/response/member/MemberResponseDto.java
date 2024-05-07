package project.mdm.dto.response.member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import project.mdm.common.Role;
import project.mdm.dto.request.member.MemberRegisterDto;
import project.mdm.entity.Member;

import java.time.LocalDate;

/**
 * -Response-
 * 사용자 정보 반환 Dto
 */

@Getter
@Setter
@NoArgsConstructor
public class MemberResponseDto {
    // 사용자 DB 인덱스 값을 굳이 사용자에게 노출시킬 필요는 없다고 생각
    private String email;
    private String username;
    private String password;
    private String passwordCheck;
    private String myName;
    private String nickname;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate birth;
    private Integer driveExp;

    @Builder
    public MemberResponseDto(String email, String username, String password, String passwordCheck, String myName, String nickname, LocalDate birth, Integer driveExp) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.passwordCheck = passwordCheck;
        this.myName = myName;
        this.nickname = nickname;
        this.birth = birth;
        this.driveExp = driveExp;
    }

    // Entity -> DTO
    public static MemberResponseDto fromEntity(Member member) {
        return MemberResponseDto.builder()
                .email(member.getEmail())
                .username(member.getUsername())
                .myName(member.getMyName())
                .nickname(member.getNickname())
                .birth(member.getBirth())
                .driveExp(member.getDriveExp())
                .build();
    }

}
