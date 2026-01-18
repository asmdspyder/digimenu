package service;

import org.springframework.stereotype.Service;

import dto.request.AdminLoginRequest;
import dto.request.AdminSignupRequest;
import dto.response.AdminLoginResponse;
import entity.User;
import repository.UserRepository;

@Service
public class AdminAuthService {

	private final UserRepository userRepository;

    public AdminAuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // ADMIN SIGNUP
    public void signup(AdminSignupRequest request) {

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        User admin = new User();
        admin.setUsername(request.getUsername());
        admin.setPassword(request.getPassword()); // plain text for now
        admin.setUserRole("ADMIN");
        admin.setActive(true);

        userRepository.save(admin);
    }

    // ADMIN LOGIN
    public AdminLoginResponse login(AdminLoginRequest request) {

        User admin = userRepository
                .findByUsernameAndUserRole(request.getUsername(), "ADMIN")
                .orElseThrow(() -> new RuntimeException("Invalid admin username"));

        if (!admin.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        if (!admin.getActive()) {
            throw new RuntimeException("Admin is inactive");
        }

        return new AdminLoginResponse(
                admin.getId(),
                admin.getUsername(),
                admin.getUserRole()
        );
    }
}