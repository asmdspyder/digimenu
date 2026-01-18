package dto.request;

public class UpdateRestaurantRequest {

    private String accountName;
    private Integer numberOfTables;
    private String logoUrl;

    private String tagline;
    private String description;
    
    private String introVideoUrl;     // ✅ ADD
    private String themeSettings;  
    
    
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
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
	public String getThemeSettings() {
		return themeSettings;
	}
	public void setThemeSettings(String themeSettings) {
		this.themeSettings = themeSettings;
	}

	
	
   
}