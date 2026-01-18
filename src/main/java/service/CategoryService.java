package service;

import org.springframework.stereotype.Service;

import dto.request.CreateCategoryRequest;
import dto.request.UpdateCategoryRequest;
import dto.response.CategoryResponse;
import entity.Account;
import entity.Category;
import repository.AccountRepository;
import repository.CategoryRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final AccountRepository accountRepository;

    public CategoryService(CategoryRepository categoryRepository,
                           AccountRepository accountRepository) {
        this.categoryRepository = categoryRepository;
        this.accountRepository = accountRepository;
    }

    public void createCategory(CreateCategoryRequest request) {

        Account account = accountRepository.findById(request.getAccountId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        Category category = new Category();
        category.setCategoryName(request.getCategoryName());
        category.setDescription(request.getDescription());
        category.setImageUrl(request.getImageUrl());
        category.setDisplayOrder(request.getDisplayOrder());
        category.setAccount(account);
        category.setActive(true);

        categoryRepository.save(category);
    }

    public void updateCategory(Long id, UpdateCategoryRequest request) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        category.setCategoryName(request.getCategoryName());
        category.setDescription(request.getDescription());
        category.setImageUrl(request.getImageUrl());
        category.setDisplayOrder(request.getDisplayOrder());

        categoryRepository.save(category);
    }

    public void activateCategory(Long id, boolean active) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        category.setActive(active);
        categoryRepository.save(category);
    }

    public List<CategoryResponse> listByRestaurant(Long accountId) {

        return categoryRepository.findByAccount_Id(accountId)
                .stream()
                .map(c -> new CategoryResponse(
                        c.getId(),
                        c.getCategoryName(),
                        c.getActive()
                ))
                .collect(Collectors.toList());
    }
}