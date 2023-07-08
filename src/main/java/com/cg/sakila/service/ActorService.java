package com.cg.sakila.service;

import com.cg.sakila.entity.Actor;
import com.cg.sakila.entity.Film;

import java.util.Collection;
import java.util.List;

public interface ActorService {
	
	Collection<Actor> findActorsByLastName(String lastName);
	Collection<Actor> findActorsByFirstName(String firstName);
	Collection<Actor> findAllActors();
	public Actor getActor(Short id);
	Actor addActor(Actor actor);
	//not yet
	List<Object[]> getTopTenActorsByFilmCount();
	Actor updateActorFirstName(Short id, Actor actor);
	Actor updateActorLastName(Short id, Actor actor);
   
}
