package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Dish;

import java.util.List;

public interface DishRepository extends JpaRepository<Dish, Long> {

    List<Dish> findByCategory_Id(Long categoryId);
    
    List<Dish> findByCategory_IdAndActiveTrue(Long categoryId);
    


}

//spring.application.name=digimenu
//
//
//											 dgzddotpywecesoolrlt
//spring.datasource.url=jdbc:postgresql://db.dgzddotpywecesoolrlt.supabase.co:5432/postgres?sslmode=require
//spring.datasource.username=postgres
//spring.datasource.password=BFellas2025!
//spring.jpa.hibernate.ddl-auto=validate
//spring.jpa.show-sql=true
