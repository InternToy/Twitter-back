package efub.intern.twitter.tweet.controller;

import efub.intern.twitter.tweet.domain.Tweet;
import efub.intern.twitter.tweet.dto.TweetRequestDto;
import efub.intern.twitter.tweet.dto.TweetResponseDto;
import efub.intern.twitter.tweet.service.TweetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tweets")
@RequiredArgsConstructor
public class TweetController {
    private final TweetService tweetService;

    // 트윗 생성
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public TweetResponseDto tweetAdd(@RequestBody TweetRequestDto requestDto){
        Tweet tweet = tweetService.addTweet(requestDto);
        return new TweetResponseDto(tweet);
    }

    // 트윗 전체 조회
    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<TweetResponseDto> tweetListFind(){
        List<Tweet> tweetList=tweetService.findTweetList();
        List<TweetResponseDto> responseDtoList=new ArrayList<>();

        for(Tweet tweet:tweetList){
            responseDtoList.add(new TweetResponseDto(tweet));
        }

        return responseDtoList;
    }

    // 트윗 개별 조회
    @GetMapping("/{tweetId}")
    @ResponseStatus(value = HttpStatus.OK)
    public TweetResponseDto tweetFind(@PathVariable Long tweetId){
        Tweet tweet=tweetService.findTweet(tweetId);
        return new TweetResponseDto(tweet);
    }

    // 트윗 삭제
    @DeleteMapping("/{tweetId}/{accountId}")
    @ResponseStatus(value = HttpStatus.OK)
    public String tweetRemove(@PathVariable Long tweetId,@PathVariable Long accountId){
        tweetService.removeTweet(tweetId,accountId);
        return "효과적으로 삭제되었습니다.";
    }
}
