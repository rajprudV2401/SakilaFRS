package com.cg.sakila.service;

import java.util.List;

import com.cg.sakila.entity.Film;

public interface FilmService {
	
	Film createFilm(Film film);
	List<Film> searchFilmsByTitle(String title);
    List<Film> searchFilmsByReleaseYear(int year);
    List<Film> findFilmsByRentalDurationGreaterThan(int rentalDuration);
    List<Film> findFilmsByRentalRateGreaterThan(double rentalRate);
    List<Film> findFilmsByLengthGreaterThan(int length);
    List<Film> findFilmsByRentalDurationLessThan(int rentalDuration);
    List<Film> findFilmsByRentalRateLessThan(double rentalRate);
    List<Film> findFilmsByLengthLessThan(int length);
    List<Film> getFilmsReleasedBetweenYears(int fromYear, int toYear);
    List<Film> findFilmsByRatingLessThan(String rating);
    List<Film> findFilmsByRatingGreaterThan(String rating);
	List<Film> getFilmsByLanguage(String language);
	void updateFilmTitle(short id, String newTitle);
	void updateFilmReleaseYear(Short id, Integer newReleaseYear);
	void updateFilmRentalDuration(Short id, Integer newRentalDuration);
	void updateFilmRentalRate(Short id, Double newRentalRate);
	void updateFilmRating(Short id, String newRating);
	void updateFilmLanguage(Short filmId, String languageName);
    List<Object[]> countFilmsByYear();
	Film getFilmById(Short filmId);
	
	public Film updateFilmTitleById(short id,Film film);
}
