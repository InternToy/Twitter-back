package efub.intern.twitter.tweet.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/*
{
	"writer" : "2",
	"content" : "오늘 날씨가 좋아요~!"
}
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TweetRequestDto {
    @NotBlank(message = "계정ID는 필수입니다.")
    private Long writerId;

    @NotBlank(message = "내용은 필수입니다.")
    private String content;

    @Builder
    public TweetRequestDto(Long writerId,String content){
        this.writerId=writerId;
        this.content=content;
    }

}
