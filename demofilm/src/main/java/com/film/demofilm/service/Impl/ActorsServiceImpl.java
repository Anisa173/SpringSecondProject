package com.film.demofilm.service.Impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.film.demofilm.domain.dto.ActorsDto;
import com.film.demofilm.domain.exception.AppException;
import com.film.demofilm.domain.mapper.ActorsMapper;
import com.film.demofilm.entity.Actors;
import com.film.demofilm.entity.Films;
import com.film.demofilm.repository.ActorsRepository;
import com.film.demofilm.service.ActorsService;
import com.film.demofilm.service.FilmsService;
import jakarta.validation.Valid;

@Validated
@Service
public class ActorsServiceImpl implements ActorsService {

	@Autowired
	private final ActorsMapper actMapper;
	@Autowired
	private final ActorsRepository actRep;
	@Autowired
	private final FilmsService fService;

	public ActorsServiceImpl(ActorsMapper actMapper, ActorsRepository actRep, FilmsService fService) {
		this.actMapper = actMapper;
		this.actRep = actRep;
		this.fService = fService;
	}

	@Override
	public ActorsDto create( Integer categoryId, Integer idFilm,@Valid ActorsDto actDto) throws Exception {
		var location = fService.getFilmById(idFilm, categoryId);
		var result = actMapper.toEntity(actDto);
		List<Films> film = (List<Films>) location;
		result.setFilms(film);
		var result1 = actRep.save(result);
		return actMapper.toDto(result1);
	}

	@Override
	public ActorsDto update(@Valid ActorsDto actDto, Integer idFilm, Integer actorId) throws Exception {
		var loc = getActorById(actorId,idFilm);
		var result1 = actMapper.toUpdate(actDto,loc);
		result1.setFilms((List<Films>) loc);
		var result = actRep.save(result1);
		return actMapper.toDto(result);
	}

	@Override
	public void delete(Integer actorId, Integer idFilm) throws Exception {
		actRep.delete(actorId,idFilm);
	}

	@Override
	public Actors getActor(Integer actorId) throws Exception {
		
		return actRep.findById(actorId).orElseThrow(() -> new AppException("Actor not Found",HttpStatus.BAD_REQUEST));
	}

	@Override
	public Actors getActorById(Integer actorId, Integer idFilm) throws Exception {
		
		return actRep.getActorById(actorId,idFilm);
	}

	@Override
	public List<ActorsDto> getActorsByFilmId(Integer idFilm) throws Exception {
		return actRep.getActorsByFilmId(idFilm);
	}

	@Override
	public List<ActorsDto> getAllActorsById() throws Exception {
		
		return actRep.getAllActorsById();
	}

	@Override
	public ActorsDto getActorFilmById(Integer actorId, Integer idFilm) throws Exception {
		var x = actRep.getActorById(actorId,idFilm);
		var y = actMapper.toDto(x);
		return y;
	}

}
