package com.cg.sakila.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.cg.sakila.entity.Actor;
import com.cg.sakila.entity.Film;

@Transactional
@Repository
public interface ActorRepository extends JpaRepository<Actor,Short>{
	
	
	List<Actor> findByLastName(String lastName);
	List<Actor> findByFirstName(String firstName);
	//@Query("SELECT a FROM Actor a ORDER BY SIZE(a.films) DESC LIMIT 10")
//	@Query("SELECT a.actorId, a.firstName, a.lastName, COUNT(f) AS filmCount " +
//	            "FROM Actor a JOIN a.films f " +
//	            "GROUP BY a.actorId, a.firstName, a.lastName " +
//	            "ORDER BY filmCount DESC")
//	 @Query("SELECT a.actorId, a.firstName, a.lastName, COUNT(f) AS filmCount " +
//	            "FROM Actor a JOIN a.films f " +
//	            "GROUP BY a.actorId, a.firstName, a.lastName " +
//	            "ORDER BY filmCount DESC " +
//	            "LIMIT 10")ex
//	@Query("SELECT actor.actorId, actor.firstName, actor.lastName,"+ 
//			"COUNT(actor) AS film_count FROM Actor actor JOIN FilmActor ON"+
//			"actor.actorId = FilmActor.actor GROUP BY actor.actorId,"+
//			" actor.firstName, actor.lastName ORDER BY film_count DESC LIMIT 10")
	
//	@Query("SELECT a.actorId, a.firstName, a.lastName, COUNT(a) AS film_count"+
//			"FROM Actor a"+
//			"JOIN FilmActor fa ON a.actorId = fa.actor"+
//			"GROUP BY a.actorId, a.firstName, a.lastName"+
//			"ORDER BY film_count DESC")
	@Query("SELECT fa.actor, COUNT(fa) AS film_count " +
		       "FROM FilmActor fa " +
		       "GROUP BY fa.actor " +
		       "ORDER BY film_count DESC")
	List<Object[]> findTopTenActorsByFilmCount();
	
}
