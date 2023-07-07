package com.cg.sakila.controller;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sakila.entity.Actor;
import com.cg.sakila.entity.Category;
import com.cg.sakila.entity.Film;
import com.cg.sakila.repository.FilmRepository;
import com.cg.sakila.service.FilmActorService;
import com.cg.sakila.service.FilmCategoryService;
import com.cg.sakila.service.FilmService;
import com.cg.sakila.service.FilmServiceImpl;

@RestController
@RequestMapping("api/films")
public class FilmController {
	
	@Autowired
	FilmService filmService;
	@Autowired
	FilmRepository filmRepository;
	@Autowired
	FilmActorService filmActorService;
	@Autowired
	FilmCategoryService filmCategoryService;
	@Autowired
	FilmServiceImpl filmServiceImpl;
    
    @PostMapping("/post")
    public ResponseEntity<String> addFilm(@Valid @RequestBody Film film) {
        Film createdFilm = filmService.createFilm(film);
        if (createdFilm != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Record Created Successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    //working
    @GetMapping("/title/{title}")
    public ResponseEntity<List<Film>> searchFilmsByTitle(@PathVariable String title) {
        List<Film> films = filmService.searchFilmsByTitle(title);
        if (films.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(films, HttpStatus.OK);
    }
    
    //working
    @GetMapping("/year/{year}")
    public ResponseEntity<List<Film>> searchFilmsByReleaseYear(@PathVariable int year) {
        List<Film> films = filmService.searchFilmsByReleaseYear(year);
        if (films.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(films, HttpStatus.OK);
    }
    
    //working
    @GetMapping("/duration/gt/{rd}")
    public List<Film> findFilmsByRentalDurationGreaterThan(@PathVariable("rd") int rentalDuration) {
        return filmService.findFilmsByRentalDurationGreaterThan(rentalDuration);
    }
    
    //working
    @GetMapping("/rate/gt/{rate}")
    public List<Film> findFilmsByRentalRateGreaterThan(@PathVariable("rate") double rentalRate) {
        return filmService.findFilmsByRentalRateGreaterThan(rentalRate);
    }
    
    //working
    @GetMapping("/length/gt/{length}")
    public List<Film> findFilmsByLengthGreaterThan(@PathVariable("length") int length) {
        return filmService.findFilmsByLengthGreaterThan(length);
    }
    
    //working
    @GetMapping("/duration/lt/{rentalDuration}")
    public List<Film> findFilmsByRentalDurationLessThan(@PathVariable("rentalDuration") int rentalDuration) {
        return filmService.findFilmsByRentalDurationLessThan(rentalDuration);
    }
    
    //working
    @GetMapping("/rate/lt/{rentalRate}")
    public List<Film> findFilmsByRentalRateLessThan(@PathVariable("rentalRate") double rentalRate) {
        return filmService.findFilmsByRentalRateLessThan(rentalRate);
    }
    
    //working
    @GetMapping("/length/lt/{length}")
    public List<Film> findFilmsByLengthLessThan(@PathVariable("length") int length) {
        return filmService.findFilmsByLengthLessThan(length);
    }
    
    //working
    @GetMapping("/betweenyear/{from}/{to}")
    public List<Film> getFilmsReleasedBetweenYears(
            @PathVariable int from,
            @PathVariable int to
    ) {
        return filmService.getFilmsReleasedBetweenYears(from, to);
    }
    
    //working
    @GetMapping("/rating/lt/{rating}")
    public List<Film> findFilmsByRatingLessThan(@PathVariable("rating") String rating) {
        return filmService.findFilmsByRatingLessThan(rating);
    }
    
    //working
    @GetMapping("/rating/gt/{rating}")
    public List<Film> getFilmsByRatingGreaterThan(@PathVariable String rating) {
        return filmService.findFilmsByRatingGreaterThan(rating);
    }
    
    //working
    @GetMapping("/language/{lang}")
    public List<Film> getFilmsByLanguage(@PathVariable("lang") String language) {
        return filmService.getFilmsByLanguage(language);
    }
    

    //working
    @GetMapping("/countbyyear")
    public ResponseEntity<List<Object[]>> countFilmsByYear() {
        List<Object[]> filmsByYear = filmService.countFilmsByYear();
        return ResponseEntity.ok(filmsByYear);
    }
    
    //find all actors of film by film id
    
    //find all films of specified category
    
    //Assign actor to film

    
    //Update Title of a Film
    @PutMapping("/update/title/{id}")
    public ResponseEntity<String> updateFilmTitle(@Valid @PathVariable("id") short id, @RequestBody Map<String, String> requestBody) {
        String newTitle = requestBody.get("newTitle");
        if (newTitle == null) {
            return ResponseEntity.badRequest().body("New title is required");
        }

        filmService.updateFilmTitle(id, newTitle);
        return ResponseEntity.status(HttpStatus.OK).body("Film title updated successfully");
    }

    //working
    //Update Release Year of a Film
    @PutMapping("/update/releaseyear/{id}")
    public ResponseEntity<String> updateFilmReleaseYear(@Valid @PathVariable("id") Short id, @RequestBody Map<String, Integer> requestBody) {
        Integer newReleaseYear = requestBody.get("newReleaseYear");
        if (newReleaseYear == null) {
            return ResponseEntity.badRequest().body("New release year is required");
        }

        filmService.updateFilmReleaseYear(id, newReleaseYear);
        return ResponseEntity.status(HttpStatus.OK).body("Film release year updated successfully");
    }

    
    //Update Rental Duration of a Film
    @PutMapping("/update/rentalduration/{id}")
    public ResponseEntity<String> updateFilmRentalDuration(@PathVariable("id") Short id, @RequestBody Map<String, Integer> requestBody) {
        Integer newRentalDuration = requestBody.get("newRentalDuration");
        if (newRentalDuration == null) {
            return ResponseEntity.badRequest().body("New rental duration is required");
        }

        filmService.updateFilmRentalDuration(id, newRentalDuration);
        return ResponseEntity.status(HttpStatus.OK).body("Film rental duration updated successfully");
    }


    
    //Update Rental Rate of a Film
    @PutMapping("/update/rentalrate/{id}")
    public ResponseEntity<String> updateFilmRentalRate(@PathVariable("id") Short id, @RequestBody Map<String, Double> requestBody) {
        Double newRentalRate = requestBody.get("newRentalRate");
        if (newRentalRate == null) {
            return ResponseEntity.badRequest().body("New rental rate is required");
        }

        filmService.updateFilmRentalRate(id, newRentalRate);
        return ResponseEntity.status(HttpStatus.OK).body("Film rental rate updated successfully");
    }

    
    //Update Rating of a Film
    @PutMapping("/update/rating/{id}")
    public ResponseEntity<String> updateFilmRating(@PathVariable("id") Short id, @RequestBody Map<String, String> requestBody) {
        String newRating = requestBody.get("newRating");
        if (newRating == null) {
            return ResponseEntity.badRequest().body("New rating is required");
        }

        filmService.updateFilmRating(id, newRating);
        return ResponseEntity.status(HttpStatus.OK).body("Film rating updated successfully");
    }

    
    //Update Language of a Film
    @PutMapping("/update/language/{id}")
    public ResponseEntity<String> updateFilmLanguage(@PathVariable("id") Short id, @RequestBody Map<String,String> requestBody) {
    	String newLanguage=requestBody.get("newLanguage");
        if (newLanguage == null) {
            return ResponseEntity.badRequest().body("New language is required");
        }

        filmService.updateFilmLanguage(id, newLanguage);
        return ResponseEntity.status(HttpStatus.OK).body("Film language updated successfully");
    }
    
    
  //Find all Actors of a Film by Film id
    @GetMapping("/{id}/actors")
    public List<Actor> findAllActorsByFilmId(@PathVariable("id") Short filmId) {
        return filmActorService.findAllActorsByFilmId(filmId);
    }
    
    //Assign Actor to a Film
    @PutMapping("{id}/actor")
    public void assignActorToFilm(@PathVariable("id") Short filmId, @RequestBody Actor actor) {
        filmActorService.assignActorToFilm(filmId, actor);
    }
    
    //Assign category to a Film
    @PutMapping("update/category/{id}")
    public ResponseEntity<String> assignCategoryToFilm(@PathVariable("id") short filmId, @RequestBody Category category) {
        filmCategoryService.assignCategoryToFilm(filmId, category);
        return ResponseEntity.ok("Category successfully assigned to the film!");
    }
    
    //Find all Films of specified {category}
    @GetMapping("/category/{category}")
    public List<Film> getFilmsByCategory(@PathVariable("category") String category) {
        return filmCategoryService.getFilmsByCategory(category);
    }
    
    //Update Category of a Film
    
}
