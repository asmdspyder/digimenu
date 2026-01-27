package repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsernameAndUserRole(String username, String userRole);

    boolean existsByUsername(String username);
    
    List<User> findByAccount_Id(Long accountId);
}