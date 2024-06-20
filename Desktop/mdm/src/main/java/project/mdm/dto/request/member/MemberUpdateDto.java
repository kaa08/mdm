package project.mdm.dto.request.member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * -Request-
 * 회원 정보 변경 요청 dto
 */

@Getter
@Setter
@NoArgsConstructor
public class MemberUpdateDto {
    private String password;
    private String passwordCheck;
    private String username;
    private String myName;
    private String nickname;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate birth;

    private Integer driveExp;

    @Builder
    public MemberUpdateDto(String password, String passwordCheck, String username, String myName, String nickname, LocalDate birth, Integer driveExp) {
        this.password = password;
        this.passwordCheck = passwordCheck;
        this.username = username;
        this.myName = myName;
        this.nickname = nickname;
        this.birth = birth;
        this.driveExp = driveExp;
    }
}
