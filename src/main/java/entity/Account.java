package entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_id", unique = true, nullable = false)
    private String accountId;

    @Column(name = "account_name", nullable = false)
    private String accountName;

    @Column(name = "is_active")
    private Boolean active = true;

    @Column(name = "theme_settings")
    private String themeSettings;

    @Column(name = "number_of_tables")
    private Integer numberOfTables;

    @Column(name = "logo_url")
    private String logoUrl;

    @Column(name = "intro_video_url")
    private String introVideoUrl;

    private String tagline;
    private String description;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();

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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}


    
}