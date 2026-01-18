package controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dto.request.CreateUserRequest;
import dto.request.UpdateUserRequest;
import dto.response.UserResponse;
import service.UserService;

import java.util.List;

@RestController
@RequestMapping("/admin/users")
public class AdminUserController {

    private final UserService userService;

    public AdminUserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody CreateUserRequest request) {
        userService.createUser(request);
        return ResponseEntity.ok("User created successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(
            @PathVariable Long id,
            @RequestBody UpdateUserRequest request) {
        userService.updateUser(id, request);
        return ResponseEntity.ok("User updated successfully");
    }

    @PutMapping("/{id}/activate")
    public ResponseEntity<String> activate(
            @PathVariable Long id,
            @RequestParam boolean active) {
        userService.activateUser(id, active);
        return ResponseEntity.ok("User status updated");
    }

    @GetMapping("/restaurant/{accountId}")
    public ResponseEntity<List<UserResponse>> list(
            @PathVariable Long accountId) {
        return ResponseEntity.ok(userService.listUsersByRestaurant(accountId));
    }
}