package service;

import org.springframework.stereotype.Service;

import dto.request.CreateDishRequest;
import dto.request.UpdateDishRequest;
import dto.response.DishResponse;
import entity.Account;
import entity.Category;
import entity.Dish;
import repository.AccountRepository;
import repository.CategoryRepository;
import repository.DishRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DishService {

        private final DishRepository dishRepository;
        private final CategoryRepository categoryRepository;
        private final AccountRepository accountRepository;

        public DishService(DishRepository dishRepository,
                        CategoryRepository categoryRepository,
                        AccountRepository accountRepository) {
                this.dishRepository = dishRepository;
                this.categoryRepository = categoryRepository;
                this.accountRepository = accountRepository;
        }

        public void createDish(CreateDishRequest request) {

                Category category = categoryRepository.findById(request.getCategoryId())
                                .orElseThrow(() -> new RuntimeException("Category not found"));

                Account account;
                if (request.getAccountId() != null) {
                        account = accountRepository.findById(request.getAccountId())
                                        .orElseThrow(() -> new RuntimeException("Restaurant not found"));
                } else {
                        account = category.getAccount();
                }

                Dish dish = new Dish();
                dish.setDishName(request.getDishName());
                dish.setIsVeg(request.getIsVeg());
                dish.setDescription(request.getDescription());
                dish.setPrice(request.getPrice());
                dish.setCurrency(request.getCurrency());
                dish.setImageUrl(request.getImageUrl());
                dish.setVideoUrl(request.getVideoUrl());
                dish.setTagIdsList(request.getTagIdsList());
                dish.setCategory(category);
                dish.setAccount(account);
                dish.setActive(true);
                dish.setDisplayOrder(request.getDisplayOrder());

                dishRepository.save(dish);
        }

        public void updateDish(Long id, UpdateDishRequest request) {

                Dish dish = dishRepository.findById(id)
                                .orElseThrow(() -> new RuntimeException("Dish not found"));

                dish.setDishName(request.getDishName());
                dish.setIsVeg(request.getIsVeg());
                dish.setDescription(request.getDescription());
                dish.setPrice(request.getPrice());
                dish.setCurrency(request.getCurrency());
                dish.setImageUrl(request.getImageUrl());
                dish.setVideoUrl(request.getVideoUrl());
                dish.setTagIdsList(request.getTagIdsList());
                dish.setDisplayOrder(request.getDisplayOrder());

                dishRepository.save(dish);
        }

        public void activateDish(Long id, boolean active) {

                Dish dish = dishRepository.findById(id)
                                .orElseThrow(() -> new RuntimeException("Dish not found"));

                dish.setActive(active);
                dishRepository.save(dish);
        }

        public List<DishResponse> listByCategory(Long categoryId) {

                return dishRepository.findByCategory_Id(categoryId)
                                .stream()
                                .map(d -> new DishResponse(
                                                d.getId(),
                                                d.getDishName(),
                                                d.getIsVeg(),
                                                d.getDescription(),
                                                d.getPrice(),
                                                d.getCurrency(),
                                                d.getImageUrl(),
                                                d.getVideoUrl(),
                                                d.getTagIdsList(),
                                                d.getDisplayOrder(),
                                                d.getActive()))
                                .collect(Collectors.toList());
        }
}
