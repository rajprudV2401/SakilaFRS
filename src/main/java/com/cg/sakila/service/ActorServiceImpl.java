package com.cg.sakila.service;

import org.springframework.stereotype.Service;

import com.cg.sakila.entity.Actor;
import com.cg.sakila.entity.Film;
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
        return actorRepository.findByLastName(lastName);
    }

    @Override
    public List<Actor> findActorsByFirstName(String firstName) {
        return actorRepository.findByFirstName(firstName);
    }
    
	@Override
    public Actor updateActorLastName(Short id, String lastName) {
        Actor actor = actorRepository.findById(id).orElse(null);
        if (actor != null) {
            actor.setLastName(lastName);
            return actorRepository.save(actor);
        }
        return null;
    }

    @Override
    public Actor updateActorFirstName(Short id, String firstName) {
        Actor actor = actorRepository.findById(id).orElse(null);
        if (actor != null) {
            actor.setFirstName(firstName);
            return actorRepository.save(actor);
        }
        return null;
    }
    
    //not yet
//    @Override
//    public List<Object[]> getTopTenActorsByFilmCount() {
//        return actorRepository.findTopTenActorsByFilmCount();
//    	//return null;
//    }
    
}
