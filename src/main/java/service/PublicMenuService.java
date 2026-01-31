package service;

import org.springframework.stereotype.Service;

import dto.response.PublicAccountResponse;
import dto.response.PublicCategoryResponse;
import dto.response.PublicDishResponse;
import dto.response.PublicMenuResponse;
import entity.Account;
import entity.Category;
import entity.Dish;
import repository.AccountRepository;
import repository.CategoryRepository;
import repository.DishRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublicMenuService {

        private final CategoryRepository categoryRepository;
        private final DishRepository dishRepository;
        private final AccountRepository accountRepository;

        public PublicMenuService(CategoryRepository categoryRepository,
                        DishRepository dishRepository,
                        AccountRepository accountRepository) {
                this.categoryRepository = categoryRepository;
                this.dishRepository = dishRepository;
                this.accountRepository = accountRepository;
        }

        public PublicMenuResponse getMenu(String accountId) {

                Account account = accountRepository.findByAccountId(accountId)
                                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

                PublicAccountResponse accountResponse = new PublicAccountResponse(
                                account.getAccountId(),
                                account.getAccountName(),
                                account.getLogoUrl(),
                                account.getTagline(),
                                account.getDescription(),
                                account.getNumberOfTables(),
                                account.getThemeSettings(),
                                account.getIntroVideoUrl());

                // Rule B: only ACTIVE categories
                List<Category> categories = categoryRepository
                                .findByAccount_AccountIdAndActiveTrueOrderByDisplayOrderAsc(accountId);

                List<PublicCategoryResponse> categoryResponses = categories.stream().map(category -> {

                        // Rule B: dishes shown ONLY if category is active
                        List<Dish> dishes = dishRepository.findByCategory_IdAndActiveTrue(category.getId());

                        List<PublicDishResponse> dishResponses = dishes.stream()
                                        .map(d -> new PublicDishResponse(
                                                        d.getId(),
                                                        d.getDishName(),
                                                        d.getIsVeg(),
                                                        d.getDescription(),
                                                        d.getPrice(),
                                                        d.getCurrency(),
                                                        d.getImageUrl(),
                                                        d.getVideoUrl(),
                                                        d.getTagIdsList()))
                                        .collect(Collectors.toList());

                        return new PublicCategoryResponse(
                                        category.getId(),
                                        category.getCategoryName(),
                                        category.getImageUrl(),
                                        dishResponses);

                }).collect(Collectors.toList());

                return new PublicMenuResponse(accountResponse, categoryResponses);
        }
}
