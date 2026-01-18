package controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dto.request.AdminLoginRequest;
import dto.request.AdminSignupRequest;
import dto.response.AdminLoginResponse;
import service.AdminAuthService;

@RestController
@RequestMapping("/admin/auth")
public class AdminAuthController {

    private final AdminAuthService adminAuthService;

    public AdminAuthController(AdminAuthService adminAuthService) {
        this.adminAuthService = adminAuthService;
    }

    // ADMIN SIGNUP
    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody AdminSignupRequest request) {
        adminAuthService.signup(request);
        return ResponseEntity.ok("Admin created successfully");
    }

    // ADMIN LOGIN
    @PostMapping("/login")
    public ResponseEntity<AdminLoginResponse> login(@RequestBody AdminLoginRequest request) {
        return ResponseEntity.ok(adminAuthService.login(request));
    }
}
