package repository;


import org.springframework.data.jpa.repository.JpaRepository;

import entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsernameAndUserRole(String username, String userRole);

    boolean existsByUsername(String username);
    
    List<User> findByAccount_Id(Long accountId);
}