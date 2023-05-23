package efub.intern.twitter.tweet.service;

import efub.intern.twitter.account.domain.Account;
import efub.intern.twitter.account.repository.AccountRepository;
import efub.intern.twitter.tweet.domain.Tweet;
import efub.intern.twitter.tweet.dto.TweetRequestDto;
import efub.intern.twitter.tweet.repository.TweetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TweetService {
    private final TweetRepository tweetRepository;
    private final AccountRepository accountRepository;

    // 트윗 생성
    public Tweet addTweet(TweetRequestDto requestDto) {
        Account writer=accountRepository.findById(requestDto.getWriterId())
                .orElseThrow(()-> new IllegalArgumentException("존재하지 않는 계정입니다."));
        return tweetRepository.save(
                Tweet.builder()
                        .writer(writer)
                        .content(requestDto.getContent())
                        .build()
        );
    }

    // 전체 트윗 조회
    public List<Tweet> findTweetList() {
        return tweetRepository.findAll();
    }

    // 트윗 개별 조회
    public Tweet findTweet(Long tweetId) {
        return tweetRepository.findById(tweetId).
                orElseThrow(()->new IllegalArgumentException("존재하지 않는 트윗입니다."));
    }

    // 트윗 삭제
    public void removeTweet(Long tweetId, Long accountId) {
        Tweet tweet=tweetRepository.findByTweetIdAndWriter_AccountId(tweetId,accountId)
                .orElseThrow(()->new IllegalArgumentException("존재하지 않는 트윗입니다."));
        tweetRepository.delete(tweet);

    }
}
