package efub.intern.twitter.tweet.dto;

import efub.intern.twitter.tweet.domain.Tweet;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/*
{
	"twitId" : "1",
	"writer" : "2",
	"nickname" : "efub",
	"content" : "오늘 날씨가 좋아요~!",
	"created" : "2023-05-18"
	"updated" : "2023-05-18"

}
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TweetResponseDto {
    private Long tweetId;
    private Long writer;
    private String nickname;
    private String content;
    private LocalDateTime created;
    private LocalDateTime updated;

    public TweetResponseDto(Tweet tweet){
        this.tweetId=tweet.getTweetId();
        this.writer=tweet.getWriter().getAccountId();
        this.nickname=tweet.getWriter().getNickname();
        this.content=tweet.getContent();
        this.created=tweet.getCreatedDate();
        this.updated=tweet.getModifiedDate();
    }


}
