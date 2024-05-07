package project.mdm.dto.request.member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import project.mdm.common.Role;
import project.mdm.entity.Member;

import java.time.LocalDate;

/**
 * -Request-
 * 회원 가입 요청 dto
 */
@Getter
@Setter
@NoArgsConstructor
public class MemberRegisterDto {

    private String email;
    private String password;
    private String passwordCheck;
    private String username;
    private String myName;
    private String nickname;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate birth;
    private Integer driveExp;

    @Builder
    public MemberRegisterDto(String email, String password, String passwordCheck, String username, String myName, String nickname, LocalDate birth, Integer driveExp) {
        this.email = email;
        this.password = password;
        this.passwordCheck = passwordCheck;
        this.username = username;
        this.myName = myName;
        this.nickname = nickname;
        this.birth = birth;
        this.driveExp = driveExp;
    }

    // DTO -> Entity
    public static Member ofEntity(MemberRegisterDto dto) {
        return Member.builder()
                .email(dto.getEmail())
                .password(dto.getPassword())
                .username(dto.getUsername())
                .myName(dto.getMyName())
                .nickname(dto.getNickname())
                .birth(dto.getBirth())
                .driveExp(dto.getDriveExp())
                .roles(Role.USER)
                .build();
    }
}
