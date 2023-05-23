package efub.intern.twitter.account.repository;


import efub.intern.twitter.account.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
    Boolean existsByEmail(String email);

}
