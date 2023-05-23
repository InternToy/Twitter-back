package efub.intern.twitter.account.controller;

import efub.intern.twitter.account.domain.Account;
import efub.intern.twitter.account.dto.AccountResponseDto;
import efub.intern.twitter.account.dto.AccountSignUpRequestDto;
import efub.intern.twitter.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController //JSON 형태로 객체 데이터를 반환.
@RequestMapping("/accounts") // 요청이 들어온 URI 와 Annotation 의 value 가 일치하면 해당 클래스나 메소드 실행.
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    // 계정 생성
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public AccountResponseDto signUp(@RequestBody @Valid final AccountSignUpRequestDto requestDto){
        Long id=accountService.signUp(requestDto);
        Account findAccount = accountService.findAccountById(id);
        return AccountResponseDto.from(findAccount);
    }

    //계정 조회
    @GetMapping("/{accountId}")
    @ResponseStatus(value = HttpStatus.OK)
    public AccountResponseDto getAccount(@PathVariable Long accountId){
        Account findAccount=accountService.findAccountById(accountId);
        return AccountResponseDto.from(findAccount);
    }
}
