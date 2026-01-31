package dto.response;

import java.util.List;

public class PublicMenuResponse {
    private PublicAccountResponse restaurant;
    private List<PublicCategoryResponse> categories;

    public PublicMenuResponse(PublicAccountResponse restaurant, List<PublicCategoryResponse> categories) {
        this.restaurant = restaurant;
        this.categories = categories;
    }

    public PublicAccountResponse getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(PublicAccountResponse restaurant) {
        this.restaurant = restaurant;
    }

    public List<PublicCategoryResponse> getCategories() {
        return categories;
    }

    public void setCategories(List<PublicCategoryResponse> categories) {
        this.categories = categories;
    }
}
