package efub.intern.twitter.account.domain;

import efub.intern.twitter.global.entity.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static efub.intern.twitter.account.domain.AccountStatus.REGISTERED;

@Entity
@NoArgsConstructor
@Getter
public class Account extends BaseTimeEntity {
    //기본키는 accountId
    //email, password, nickname, joined
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id",updatable = false)
    private Long accountId;

    @Column(nullable = false,length = 60)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false,updatable = false,length = 16)
    private String nickname;


    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    @Builder
    public Account(String email,String password,String nickname){
        this.email=email;
        this.password=password;
        this.nickname=nickname;
        this.status=REGISTERED;
    }


}
