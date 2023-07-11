package com.cg.sakila.service;

import org.springframework.stereotype.Service;

import com.cg.sakila.entity.Actor;
import com.cg.sakila.entity.Film;
import com.cg.sakila.exception.ActorNotFoundException;
import com.cg.sakila.repository.ActorRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

	private ActorRepository actorRepository;
	
	@Autowired
	public void setActorRepository(ActorRepository actorRepository) {
		this.actorRepository = actorRepository;
	}
	
    @Override
    public List<Actor> findAllActors() {
        return actorRepository.findAll();
    }

    @Override
    public Actor addActor(Actor actor) {
        return actorRepository.save(actor);
    }
    
    @Override
    public List<Actor> findActorsByLastName(String lastName) {
    	List<Actor> actor = actorRepository.findByLastName(lastName);
    	if(actor.isEmpty()==true) {
    		throw new ActorNotFoundException("Actor with Lastname: "+lastName+",is not avialable");
    	}
        return actorRepository.findByLastName(lastName);
    }

    @Override
    public List<Actor> findActorsByFirstName(String firstName) {
    	List<Actor> actors=actorRepository.findByFirstName(firstName);
    	if(actors.isEmpty()==true) {
    		throw new ActorNotFoundException("Actor with firstName"+firstName+" is not available");
    	}
        return actorRepository.findByFirstName(firstName);
    }
    
	@Override
    public Actor updateActorLastName(Short id, Actor actor) {
		Actor existingactor = getActor(id);
		existingactor.setLastName(actor.getLastName());
		existingactor.setLastUpdate(actor.getLastUpdate());
		return actorRepository.save(existingactor);
    }

    @Override
    public Actor updateActorFirstName(Short id, Actor actor) {
    	Actor existingactor = getActor(id);
		existingactor.setFirstName(actor.getFirstName());
		existingactor.setLastUpdate(actor.getLastUpdate());
		return actorRepository.save(existingactor);
    }

	@Override
	public Actor getActor(Short id) {
		return actorRepository.findById(id).orElseThrow(()-> new ActorNotFoundException("Actor with ID: "+id+",is not available"));
	}
    
    //working
    @Override
    public List<Object[]> getTopTenActorsByFilmCount() {
    	 List<Object[]> results = actorRepository.findTopTenActorsByFilmCount();
    	 List<Object[]> firstTenElements = results.subList(0, 10);
    	 return firstTenElements;
    }

	@Override
	public List<Film> getFilmsByActorId(Short actorId) {
		List<Film> allLists=actorRepository.searchFilmsByActorId(actorId);
		if(allLists.isEmpty()==true) {
			throw new ActorNotFoundException("no data available");
		}
		return actorRepository.searchFilmsByActorId(actorId);
	}
    
}
