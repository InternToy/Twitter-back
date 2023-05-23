package efub.intern.twitter.tweet.domain;

import efub.intern.twitter.account.domain.Account;
import efub.intern.twitter.global.entity.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Tweet extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tweetId;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account writer;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Builder
    public Tweet(Long tweetId,Account writer,String content){
        this.tweetId=tweetId;
        this.writer=writer;
        this.content=content;
    }
}
