package controller;



import service.UserCategoryService;
import service.UserDishService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import entity.Category;
import entity.Dish;

import java.util.List;

@RestController
@RequestMapping("/user/menu")
public class UserMenuController {

    private final UserCategoryService categoryService;
    private final UserDishService dishService;

    public UserMenuController(UserCategoryService categoryService,
                              UserDishService dishService) {
        this.categoryService = categoryService;
        this.dishService = dishService;
    }

    // View categories of restaurant
    @GetMapping("/categories")
    public ResponseEntity<List<Category>> categories(
            @RequestParam Long accountId) {
        return ResponseEntity.ok(categoryService.getActiveCategories(accountId));
    }

    // Activate / Inactivate category
    @PutMapping("/category/{id}/activate")
    public ResponseEntity<String> activateCategory(
            @PathVariable Long id,
            @RequestParam boolean active) {
        categoryService.activateCategory(id, active);
        return ResponseEntity.ok("Category status updated");
    }

    // View dishes of category
    @GetMapping("/dishes/{categoryId}")
    public ResponseEntity<List<Dish>> dishes(
            @PathVariable Long categoryId) {
        return ResponseEntity.ok(dishService.getActiveDishes(categoryId));
    }

    // Activate / Inactivate dish
    @PutMapping("/dish/{id}/activate")
    public ResponseEntity<String> activateDish(
            @PathVariable Long id,
            @RequestParam boolean active) {
        dishService.activateDish(id, active);
        return ResponseEntity.ok("Dish status updated");
    }
}