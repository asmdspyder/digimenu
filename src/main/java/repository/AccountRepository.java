package repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

    boolean existsByAccountId(String accountId);
    
    Optional<Account> findByAccountId(String accountId);

    
}