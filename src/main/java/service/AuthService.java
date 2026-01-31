package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.request.UserLoginRequest;
import dto.response.UserLoginResponse;
import entity.User;
import repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public UserLoginResponse login(UserLoginRequest request) {
        User user = userRepository
                .findByUsernameAndUserRole(request.getUsername(), "USER")
                .orElseThrow(() -> new RuntimeException("Invalid username or user not found"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        if (!user.getActive()) {
            throw new RuntimeException("User account is inactive");
        }

        Long accountId = user.getAccount() != null ? user.getAccount().getId() : null;

        return new UserLoginResponse(
                user.getId(),
                user.getUsername(),
                user.getUserRole(),
                accountId);
    }
}
