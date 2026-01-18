package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Dish;

import java.util.List;

public interface DishRepository extends JpaRepository<Dish, Long> {

    List<Dish> findByCategory_Id(Long categoryId);
    
    List<Dish> findByCategory_IdAndActiveTrue(Long categoryId);
    


}