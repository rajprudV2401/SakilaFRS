package com.cg.sakila.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.sakila.entity.Actor;
import com.cg.sakila.entity.Film;

@Transactional
@Repository
public interface ActorRepository extends JpaRepository<Actor,Short>{
	
	
	List<Actor> findByLastName(String lastName);
	List<Actor> findByFirstName(String firstName);
	@Query("SELECT fa.actor, COUNT(fa) AS film_count " +
		       "FROM FilmActor fa " +
		       "GROUP BY fa.actor " +
		       "ORDER BY film_count DESC")
	List<Object[]> findTopTenActorsByFilmCount();
	@Query("SELECT f FROM Film f JOIN f.actors a WHERE a.actorId = :actorId")
	List<Film> searchFilmsByActorId(@Param("actorId") Short actorId);
	
}
