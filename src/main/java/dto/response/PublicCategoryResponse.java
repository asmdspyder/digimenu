package dto.response;

import java.util.List;

public class PublicCategoryResponse {

	private Long id;
	private String categoryName;
	private String imageUrl;
	private Integer displayOrder;
	private List<PublicDishResponse> dishes;

	public PublicCategoryResponse(
			Long id,
			String categoryName,
			String imageUrl,
			Integer displayOrder,
			List<PublicDishResponse> dishes) {
		this.id = id;
		this.categoryName = categoryName;
		this.imageUrl = imageUrl;
		this.displayOrder = displayOrder;
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

	public Integer getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(Integer displayOrder) {
		this.displayOrder = displayOrder;
	}

	public List<PublicDishResponse> getDishes() {
		return dishes;
	}

	public void setDishes(List<PublicDishResponse> dishes) {
		this.dishes = dishes;
	}

}