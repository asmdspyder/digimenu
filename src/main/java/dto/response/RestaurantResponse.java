package dto.response;

public class RestaurantResponse {

    private Long id;
    private String accountId;
    private String accountName;
    private Boolean active;

    public RestaurantResponse(Long id, String accountId, String accountName, Boolean active) {
        this.id = id;
        this.accountId = accountId;
        this.accountName = accountName;
        this.active = active;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

    
}