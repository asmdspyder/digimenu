package dto.response;

import java.math.BigDecimal;

public class DishResponse {

    private Long id;
    private String dishName;
    private Boolean isVeg;
    private String description;
    private BigDecimal price;
    private String currency;
    private String imageUrl;
    private String videoUrl;
    private String tagIdsList;
    private Integer displayOrder;
    private Boolean active;

    public DishResponse() {
    }

    public DishResponse(Long id, String dishName, Boolean isVeg, String description, BigDecimal price,
            String currency, String imageUrl, String videoUrl, String tagIdsList, Integer displayOrder,
            Boolean active) {
        this.id = id;
        this.dishName = dishName;
        this.isVeg = isVeg;
        this.description = description;
        this.price = price;
        this.currency = currency;
        this.imageUrl = imageUrl;
        this.videoUrl = videoUrl;
        this.tagIdsList = tagIdsList;
        this.displayOrder = displayOrder;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public Boolean getIsVeg() {
        return isVeg;
    }

    public void setIsVeg(Boolean isVeg) {
        this.isVeg = isVeg;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getTagIdsList() {
        return tagIdsList;
    }

    public void setTagIdsList(String tagIdsList) {
        this.tagIdsList = tagIdsList;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}