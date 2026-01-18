package dto.response;

import java.util.List;

public class PublicCategoryResponse {

    private Long id;
    private String categoryName;
    private String imageUrl;
    private List<PublicDishResponse> dishes;

    public PublicCategoryResponse(
            Long id,
            String categoryName,
            String imageUrl,
            List<PublicDishResponse> dishes
    ) {
        this.id = id;
        this.categoryName = categoryName;
        this.imageUrl = imageUrl;
        this.dishes = dishes;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public List<PublicDishResponse> getDishes() {
		return dishes;
	}

	public void setDishes(List<PublicDishResponse> dishes) {
		this.dishes = dishes;
	}

  
}