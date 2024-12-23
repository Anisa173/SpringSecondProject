package com.film.demofilm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.film.demofilm.domain.dto.ActorsDto;
import com.film.demofilm.entity.Actors;

@Repository
public interface ActorsRepository extends JpaRepository<Actors, Integer> {

	@Query("SELECT a.idAct , f.idFilm FROM Actors a INNER JOIN Films f ON f.movies.filmsId = f.idFilm AND a.movies.actoresId=a.idAct WHERE f.idFilm=: idFilm AND a.idAct =: idAct ")
	Actors getActorById(Integer actorId, Integer filmId);

	@Query("SELECT a , f.filmTitle title FROM Actors a INNER JOIN Films f ON f.movies.filmsId = f.idFilm AND a.movies.actoresId=a.idAct WHERE f.idFilm=:idFilm ORDER BY title ASC")
	List<ActorsDto> getActorsByFilmId(Integer idFilm);

	@Query("Select a,f.filmTitle title FROM Actors a INNER JOIN Films f ON f.movies.filmsId = f.idFilm AND a.movies.actoresId=a.idAct GROUP BY a.idAct ORDER BY title")
	List<ActorsDto> getAllActorsById();

	@Query("DELETE FROM Actors a INNER JOIN Films f ON f.movies.filmsId = f.idFilm AND a.movies.actoresId=a.idAct WHERE f.idFilm=:?1 AND a.idAct=:?2 ")
	void delete(Integer actorId, Integer idFilm);

}
