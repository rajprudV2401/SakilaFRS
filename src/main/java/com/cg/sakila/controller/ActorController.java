package com.cg.sakila.controller;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sakila.entity.Actor;
import com.cg.sakila.entity.Film;
import com.cg.sakila.repository.ActorRepository;
import com.cg.sakila.service.ActorService;
import com.cg.sakila.service.ActorServiceImpl;
import com.cg.sakila.service.FilmService;

@RestController
@RequestMapping("/api/actors")
public class ActorController {

	private ActorService actorService;
	private FilmService filmService;
	private ActorRepository actorRepository;
	
	@Autowired
	public void setActorRepository(ActorRepository actorRepository) {
		this.actorRepository = actorRepository;
	}
	
	@Autowired
	public void setActorService(ActorService actorService) {
		this.actorService = actorService;
	}
	
	@Autowired
	public void setFilmService(FilmService filmService) {
		this.filmService = filmService;
	}
	
	@PostMapping("/post")
	public ResponseEntity<String> addActor(@Valid @RequestBody Actor actor) {
		actorService.addActor(actor);
		return new ResponseEntity<>("Record Created Successfully", HttpStatus.CREATED);
	}
	
	//working
	@GetMapping("/lastname/{ln}")
	public ResponseEntity<List<Actor>> searchActorsByLastName(@PathVariable String ln) {
		List<Actor> actors = (List<Actor>) actorService.findActorsByLastName(ln);
		ResponseEntity<List<Actor>> res=new ResponseEntity<List<Actor>>(actors,HttpStatus.OK);
		return res;
	}

	//working
	@GetMapping("/firstname/{fn}")
	public ResponseEntity<List<Actor>> searchActorsByFirstName(@PathVariable String fn) {
		List<Actor> actors = (List<Actor>) actorService.findActorsByFirstName(fn);
		ResponseEntity<List<Actor>> res=new ResponseEntity<List<Actor>>(actors,HttpStatus.OK);
		return res;
	}
	
	@PutMapping("/update/lastname/{id}")
	public Actor updateActorLastName(@PathVariable("id") Short id,@RequestBody Actor actor) {
		Actor updatedActor = actorService.updateActorLastName(id,actor);
		return updatedActor;
	}
	
	@PutMapping("/update/firstname/{id}")
	public Actor updateActorFirstName(@PathVariable("id") Short id,@RequestBody Actor actor) {
		Actor updateActor=actorService.updateActorFirstName(id, actor);
		return updateActor;
	}
	
	@GetMapping("/{id}/films")
	public ResponseEntity<List<Film>> getFilmsByActorId(@PathVariable("id") Short actorId) {
      List<Film> films = actorService.getFilmsByActorId(actorId);
      if (films.isEmpty()) {
          return ResponseEntity.notFound().build();
      }
      return ResponseEntity.ok(films);
	}
	
	@GetMapping("/toptenbyfilmcount")
	public List<Object[]> getTopTenActorsByFilmCount() {
		return actorService.getTopTenActorsByFilmCount();
	}
	
}
