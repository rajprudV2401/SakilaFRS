package com.cg.sakila.service;

import org.springframework.stereotype.Service;

import com.cg.sakila.entity.Actor;
import com.cg.sakila.entity.Film;
import com.cg.sakila.exception.ActorNotFoundException;
import com.cg.sakila.repository.ActorRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
//		  Actor actor = actorRepository.findById(id).orElseThrow(()-> new ActorNotFoundException("Actor with ID: "+id+",not available to update"));
//        if (actor != null) {
//            actor.setLastName(lastName);
//            return actorRepository.save(actor);
//        }
//        return null;
    }

    @Override
    public Actor updateActorFirstName(Short id, Actor actor) {
    	Actor existingactor = getActor(id);
		existingactor.setFirstName(actor.getFirstName());
		existingactor.setLastUpdate(actor.getLastUpdate());
		return actorRepository.save(existingactor);
//		  Actor actor = actorRepository.findById(id).orElseThrow(()-> new ActorNotFoundException("Actor with ID: "+id+",not available to update"));
//        if (actor != null) {
//            actor.setLastName(lastName);
//            return actorRepository.save(actor);
//        }
//        return null;
    }

	@Override
	public Actor getActor(Short id) {
		return actorRepository.findById(id).orElseThrow(()-> new ActorNotFoundException("Actor with ID: "+id+",is not available"));
	}
    
    //not yet
    @Override
    public List<Object[]> getTopTenActorsByFilmCount() {
    	 List<Object[]> results = actorRepository.findTopTenActorsByFilmCount();
    	    
//    	    List<Actor> topTenActors = results.stream()
//    	            .map(row -> (Actor) row[0])
//    	         
//    	            .collect(Collectors.toCollection(ArrayList::new));
    	    //System.out.println(topTenActors.size());
    	    List<Object[]> firstTenElements = results.subList(0, 10);
    	    return firstTenElements;
    }
    
}
