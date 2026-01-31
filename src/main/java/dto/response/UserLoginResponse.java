package dto.response;

public class UserLoginResponse {
    private Long userId;
    private String username;
    private String role;
    private Long accountId;

    public UserLoginResponse(Long userId, String username, String role, Long accountId) {
        this.userId = userId;
        this.username = username;
        this.role = role;
        this.accountId = accountId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
