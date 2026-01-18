package service;

import org.springframework.stereotype.Service;

import entity.Category;
import entity.Dish;
import repository.CategoryRepository;
import repository.DishRepository;

import java.util.List;

@Service
public class UserDishService {

    private final DishRepository dishRepository;
    private final CategoryRepository categoryRepository;

    public UserDishService(DishRepository dishRepository,
                           CategoryRepository categoryRepository) {
        this.dishRepository = dishRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Dish> getActiveDishes(Long categoryId) {

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        if (!category.getActive()) {
            return List.of(); // Rule B enforced
        }

        return dishRepository.findByCategory_IdAndActiveTrue(categoryId);
    }

    public void activateDish(Long dishId, boolean active) {
        Dish dish = dishRepository.findById(dishId)
                .orElseThrow(() -> new RuntimeException("Dish not found"));
        dish.setActive(active);
        dishRepository.save(dish);
    }
}