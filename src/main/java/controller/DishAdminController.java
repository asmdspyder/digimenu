package controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dto.request.CreateDishRequest;
import dto.request.UpdateDishRequest;
import dto.response.DishResponse;
import service.DishService;

import java.util.List;

@RestController
@RequestMapping("/admin/dishes")
public class DishAdminController {

    private final DishService dishService;

    public DishAdminController(DishService dishService) {
        this.dishService = dishService;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody CreateDishRequest request) {
        dishService.createDish(request);
        return ResponseEntity.ok("Dish created successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(
            @PathVariable Long id,
            @RequestBody UpdateDishRequest request) {
        dishService.updateDish(id, request);
        return ResponseEntity.ok("Dish updated successfully");
    }

    @PutMapping("/{id}/activate")
    public ResponseEntity<String> activate(
            @PathVariable Long id,
            @RequestParam boolean active) {
        dishService.activateDish(id, active);
        return ResponseEntity.ok("Dish status updated");
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<DishResponse>> list(
            @PathVariable Long categoryId) {
        return ResponseEntity.ok(dishService.listByCategory(categoryId));
    }
}