package controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dto.request.UserLoginRequest;
import dto.response.UserLoginResponse;
import service.AuthService;

@RestController
@RequestMapping("/user/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> login(@RequestBody UserLoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
}
