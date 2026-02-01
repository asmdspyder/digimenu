package dto.response;

import java.math.BigDecimal;

public class DishResponse {

    private Long id;
    private String dishName;
    private BigDecimal price;
    private Boolean active;

    public DishResponse() {
    }

    public DishResponse(Long id, String dishName, BigDecimal price, Boolean active) {
        this.id = id;
        this.dishName = dishName;
        this.price = price;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}