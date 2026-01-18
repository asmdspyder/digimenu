package service;

import org.springframework.stereotype.Service;

import dto.request.CreateUserRequest;
import dto.request.UpdateUserRequest;
import dto.response.UserResponse;
import entity.Account;
import entity.User;
import repository.AccountRepository;
import repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    public UserService(UserRepository userRepository,
                       AccountRepository accountRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }

    public void createUser(CreateUserRequest request) {

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        Account account = accountRepository.findById(request.getAccountId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword()); // plain text for now
        user.setUserRole("USER");
        user.setAccount(account);
        user.setActive(true);

        userRepository.save(user);
    }

    public void updateUser(Long id, UpdateUserRequest request) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setUsername(request.getUsername());
        userRepository.save(user);
    }

    public void activateUser(Long id, boolean active) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setActive(active);
        userRepository.save(user);
    }

    public List<UserResponse> listUsersByRestaurant(Long accountId) {

        return userRepository.findByAccount_Id(accountId)
                .stream()
                .map(u -> new UserResponse(
                        u.getId(),
                        u.getUsername(),
                        u.getActive()
                ))
                .collect(Collectors.toList());
    }
}