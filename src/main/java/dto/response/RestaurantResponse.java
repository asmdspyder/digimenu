package dto.response;

public class RestaurantResponse {

	private Long id;
	private String accountId;
	private String accountName;
	private Boolean active;
	private String themeSettings;
	private Integer numberOfTables;
	private String logoUrl;
	private String introVideoUrl;
	private String tagline;
	private String description;

	public RestaurantResponse() {
	}

	public RestaurantResponse(Long id, String accountId, String accountName, Boolean active,
			String themeSettings, Integer numberOfTables, String logoUrl, String introVideoUrl,
			String tagline, String description) {
		this.id = id;
		this.accountId = accountId;
		this.accountName = accountName;
		this.active = active;
		this.themeSettings = themeSettings;
		this.numberOfTables = numberOfTables;
		this.logoUrl = logoUrl;
		this.introVideoUrl = introVideoUrl;
		this.tagline = tagline;
		this.description = description;
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

	public String getThemeSettings() {
		return themeSettings;
	}

	public void setThemeSettings(String themeSettings) {
		this.themeSettings = themeSettings;
	}

	public Integer getNumberOfTables() {
		return numberOfTables;
	}

	public void setNumberOfTables(Integer numberOfTables) {
		this.numberOfTables = numberOfTables;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public String getIntroVideoUrl() {
		return introVideoUrl;
	}

	public void setIntroVideoUrl(String introVideoUrl) {
		this.introVideoUrl = introVideoUrl;
	}

	public String getTagline() {
		return tagline;
	}

	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}