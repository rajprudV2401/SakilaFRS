package com.cg.sakila.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.sakila.entity.FilmCategory;
import com.cg.sakila.entity.FilmCategoryId;

import java.util.List;

@Repository
public interface FilmCategoryRepository extends JpaRepository<FilmCategory, FilmCategoryId> {
	
	List<FilmCategory> findByCategoryName(String category);
}
