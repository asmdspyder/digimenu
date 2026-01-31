package service;

import org.springframework.stereotype.Service;

import entity.Dish;
import repository.DishRepository;

import java.util.List;

@Service
public class UserDishService {

    private final DishRepository dishRepository;

    public UserDishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public List<Dish> getDishes(Long categoryId) {
        return dishRepository.findByCategory_Id(categoryId);
    }

    public void activateDish(Long dishId, boolean active) {
        Dish dish = dishRepository.findById(dishId)
                .orElseThrow(() -> new RuntimeException("Dish not found"));
        dish.setActive(active);
        dishRepository.save(dish);
    }
}