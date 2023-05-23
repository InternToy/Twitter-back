package efub.intern.twitter.account.service;

import efub.intern.twitter.account.domain.Account;
import efub.intern.twitter.account.dto.AccountSignUpRequestDto;
import efub.intern.twitter.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service // 서비스 계층임을 명시
@Transactional //트랜잭션 저리를 위해 사용
@RequiredArgsConstructor // final 이 붙거나 @NotNull 이 붙은 필드 생성자 자동 생성 -> 의존성 외부에서 주입.
public class AccountService {
    private final AccountRepository accountRepository;
    public Long signUp(AccountSignUpRequestDto requestDto) {
        if(existsByEmail(requestDto.getEmail())){
            throw new IllegalArgumentException("이미 존재하는 email입니다."+requestDto.getNickname());
        }

        Account account = accountRepository.save(requestDto.toEntity());
        return account.getAccountId();
    }

    @Transactional(readOnly = true) // 트랜잭션을 읽기 전용 모드로 설정 -> 메모리 사용량 최적화
    public boolean existsByEmail(String email){
        return accountRepository.existsByEmail(email);
    }

    // accountID로 계정 찾기
    @Transactional(readOnly = true)
    public Account findAccountById(Long id){
        return accountRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("해당 id를 가진 Account를 찾을 수 없습니다. id= "+id));
    }


}
