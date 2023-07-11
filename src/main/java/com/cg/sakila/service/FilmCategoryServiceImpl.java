package com.cg.sakila.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.sakila.entity.Category;
import com.cg.sakila.entity.Film;
import com.cg.sakila.entity.FilmCategory;
import com.cg.sakila.entity.FilmCategoryId;
import com.cg.sakila.repository.FilmCategoryRepository;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FilmCategoryServiceImpl implements FilmCategoryService {

	 private final FilmCategoryRepository filmCategoryRepository;
	    @Autowired
	    public FilmCategoryServiceImpl(FilmCategoryRepository filmCategoryRepository) {
	        this.filmCategoryRepository = filmCategoryRepository;
	    }

	    @Override
	    public List<Film> getFilmsByCategory(String category) {
	        List<FilmCategory> filmCategories = filmCategoryRepository.findByCategoryName(category);
	        return filmCategories.stream()
	                .map(FilmCategory::getFilm)
	                .collect(Collectors.toList());
	    }

	    @Override
	    public void assignCategoryToFilm(Short filmId, Category category) {
	        Film film = new Film();
	        film.setFilmId(filmId);
	        FilmCategoryId filmCategoryId=new FilmCategoryId();
	        filmCategoryId.setFilmId(filmId);
	        filmCategoryId.setCategoryId(category.getCategoryId());
	        
	        FilmCategory filmCategory=new FilmCategory();
	        filmCategory.setId(filmCategoryId);
	        filmCategory.setFilm(film);
	        filmCategory.setCategory(category);
	        filmCategory.setLastUpdate(new Timestamp(System.currentTimeMillis()));
	        filmCategoryRepository.save(filmCategory);
	    }
}
