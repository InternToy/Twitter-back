package efub.intern.twitter.account.dto;

import efub.intern.twitter.account.domain.Account;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccountResponseDto {
    private Long accountId;
    private String email;
    private String nickname;
    private LocalDateTime joined;

    public AccountResponseDto(Long accountId,String email,String nickname,LocalDateTime joined){
        this.accountId=accountId;
        this.email=email;
        this.nickname=nickname;
        this.joined=joined;
    }

    public static AccountResponseDto from(Account account) {
        return new AccountResponseDto(account.getAccountId(),
                account.getEmail(),
                account.getNickname(),
                account.getCreatedDate());
    }


}
