package com.film.demofilm.service;

import java.util.List;

import com.film.demofilm.domain.dto.ActorsDto;
import com.film.demofilm.entity.Actors;

public interface ActorsService {

	ActorsDto create(Integer categoryId, Integer idFilm, ActorsDto actDto) throws Exception;

	ActorsDto update(ActorsDto actDto, Integer idFilm, Integer actorId) throws Exception;

	void delete(Integer actorId, Integer idFilm) throws Exception;

	List<ActorsDto> getAllActorsById() throws Exception;

	Actors getActor(Integer actorId) throws Exception;

	Actors getActorById(Integer actorId, Integer idFilm) throws Exception;

	ActorsDto getActorFilmById(Integer actorId, Integer idFilm) throws Exception;

	List<ActorsDto> getActorsByFilmId(Integer idFilm) throws Exception;

}
