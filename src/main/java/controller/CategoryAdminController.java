package controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dto.request.CreateCategoryRequest;
import dto.request.UpdateCategoryRequest;
import dto.response.CategoryResponse;
import service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/admin/categories")
public class CategoryAdminController {

    private final CategoryService categoryService;

    public CategoryAdminController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody CreateCategoryRequest request) {
        categoryService.createCategory(request);
        return ResponseEntity.ok("Category created successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(
            @PathVariable Long id,
            @RequestBody UpdateCategoryRequest request) {
        categoryService.updateCategory(id, request);
        return ResponseEntity.ok("Category updated successfully");
    }

    @PutMapping("/{id}/activate")
    public ResponseEntity<String> activate(
            @PathVariable Long id,
            @RequestParam boolean active) {
        categoryService.activateCategory(id, active);
        return ResponseEntity.ok("Category status updated");
    }

    @GetMapping("/restaurant/{accountId}")
    public ResponseEntity<List<CategoryResponse>> list(
            @PathVariable Long accountId) {
        return ResponseEntity.ok(categoryService.listByRestaurant(accountId));
    }
}