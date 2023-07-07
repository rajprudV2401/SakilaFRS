package com.cg.sakila.service;

import java.util.List;

import com.cg.sakila.entity.Category;
import com.cg.sakila.entity.Film;


public interface FilmCategoryService {
	
    List<Film> getFilmsByCategory(String category);
    void assignCategoryToFilm(Short filmId, Category category);
}
