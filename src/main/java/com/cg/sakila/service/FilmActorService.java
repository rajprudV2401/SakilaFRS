package com.cg.sakila.service;

import java.util.List;

import com.cg.sakila.entity.Actor;
import com.cg.sakila.entity.Film;

public interface FilmActorService {
	
    List<Actor> findAllActorsByFilmId(Short filmId);
    List<Film> getFilmsByActorId(Short actorId);
    void assignActorToFilm(Short filmId, Actor actor);
    void assignFilmToActor(Short actorId, Film film);    

}
