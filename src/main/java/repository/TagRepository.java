package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {

    boolean existsByTagNameIgnoreCase(String tagName);
}