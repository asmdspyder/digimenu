package service;

import org.springframework.stereotype.Service;

import dto.response.PublicCategoryResponse;
import dto.response.PublicDishResponse;
import entity.Category;
import entity.Dish;
import repository.CategoryRepository;
import repository.DishRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublicMenuService {

    private final CategoryRepository categoryRepository;
    private final DishRepository dishRepository;

    public PublicMenuService(CategoryRepository categoryRepository,
                             DishRepository dishRepository) {
        this.categoryRepository = categoryRepository;
        this.dishRepository = dishRepository;
    }

    public List<PublicCategoryResponse> getMenu(String accountId) {

        // Rule B: only ACTIVE categories
        List<Category> categories =
                categoryRepository
                        .findByAccount_AccountIdAndActiveTrueOrderByDisplayOrderAsc(accountId);

        return categories.stream().map(category -> {

            // Rule B: dishes shown ONLY if category is active
            List<Dish> dishes =
                    dishRepository.findByCategory_IdAndActiveTrue(category.getId());

            List<PublicDishResponse> dishResponses =
                    dishes.stream()
                            .map(d -> new PublicDishResponse(
                                    d.getId(),
                                    d.getDishName(),
                                    d.getIsVeg(),
                                    d.getDescription(),
                                    d.getPrice(),
                                    d.getCurrency(),
                                    d.getImageUrl(),
                                    d.getVideoUrl(),
                                    d.getTagIdsList()
                            ))
                            .collect(Collectors.toList());

            return new PublicCategoryResponse(
                    category.getId(),
                    category.getCategoryName(),
                    category.getImageUrl(),
                    dishResponses
            );

        }).collect(Collectors.toList());
    }
}
