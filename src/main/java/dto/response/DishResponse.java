package dto.response;

import java.math.BigDecimal;

public class DishResponse {

    private Long id;
    private String dishName;
    private BigDecimal price;
    private Boolean active;

    public DishResponse(Long id, String dishName, BigDecimal price, Boolean active) {
        this.id = id;
        this.dishName = dishName;
        this.price = price;
        this.active = active;
    }

  
}