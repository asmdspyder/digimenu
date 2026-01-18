package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Category;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByAccount_Id(Long accountId);
    
    List<Category> findByAccount_IdAndActiveTrue(Long accountId);
    
    List<Category> findByAccount_AccountIdAndActiveTrueOrderByDisplayOrderAsc(String accountId);


}
