package com.cg.sakila.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.sakila.entity.Film;
import com.cg.sakila.entity.Language;

@Transactional
@Repository
public interface FilmRepository extends JpaRepository<Film,Short>{

	List<Film> findByTitleContaining(String title);
    List<Film> findByReleaseYear(int year);
    List<Film> findFilmsByRentalDurationGreaterThan(int rentalDuration);
    List<Film> findFilmsByRentalRateGreaterThan(double rentalRate);
    List<Film> findFilmsByLengthGreaterThan(int length);
    List<Film> findFilmsByRentalDurationLessThan(int rentalDuration);
    List<Film> findFilmsByRentalRateLessThan(double rentalRate);
    List<Film> findFilmsByLengthLessThan(int length);
    List<Film> findFilmsByRatingLessThan(String rating); 
    List<Film> findFilmsByRatingGreaterThan(String rating);
    List<Film> findByLanguageName(String language);
	
    /*
    @Modifying
    @Query("UPDATE Film f SET f.title = :newTitle WHERE f.id = :id")
    void updateFilmTitleById(short id, String newTitle);
    */
    
    @Modifying
    @Query("UPDATE Film f SET f.language = :language WHERE f.id = :filmId")
    void updateFilmLanguage(@Param("filmId") Short filmId, @Param("language") Language language);
    
    @Query("SELECT f.releaseYear, COUNT(f) FROM Film f GROUP BY f.releaseYear")
    List<Object[]> countFilmsByYear();
    
}
