package dto.response;

public class PublicAccountResponse {
    private String accountId;
    private String accountName;
    private String logoUrl;
    private String tagline;
    private String description;
    private Integer numberOfTables;
    private String themeSettings;
    private String introVideoUrl;

    public PublicAccountResponse(String accountId, String accountName, String logoUrl, String tagline,
            String description, Integer numberOfTables, String themeSettings, String introVideoUrl) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.logoUrl = logoUrl;
        this.tagline = tagline;
        this.description = description;
        this.numberOfTables = numberOfTables;
        this.themeSettings = themeSettings;
        this.introVideoUrl = introVideoUrl;
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

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
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

    public Integer getNumberOfTables() {
        return numberOfTables;
    }

    public void setNumberOfTables(Integer numberOfTables) {
        this.numberOfTables = numberOfTables;
    }

    public String getThemeSettings() {
        return themeSettings;
    }

    public void setThemeSettings(String themeSettings) {
        this.themeSettings = themeSettings;
    }

    public String getIntroVideoUrl() {
        return introVideoUrl;
    }

    public void setIntroVideoUrl(String introVideoUrl) {
        this.introVideoUrl = introVideoUrl;
    }
}
