package service;

import org.springframework.stereotype.Service;

import entity.Category;
import repository.CategoryRepository;

import java.util.List;

@Service
public class UserCategoryService {

    private final CategoryRepository categoryRepository;

    public UserCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getActiveCategories(Long accountId) {
        return categoryRepository.findByAccount_IdAndActiveTrue(accountId);
    }

    public void activateCategory(Long categoryId, boolean active) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        category.setActive(active);
        categoryRepository.save(category);
    }
}