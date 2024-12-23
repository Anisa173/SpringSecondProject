package com.film.demofilm.service.Impl;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.film.demofilm.domain.dto.FilmsDto;
import com.film.demofilm.domain.mapper.FilmMapper;
import com.film.demofilm.entity.Films;
import com.film.demofilm.repository.FilmsRepository;
import com.film.demofilm.service.ActorsService;
import com.film.demofilm.service.FilmsCategoryService;
import com.film.demofilm.service.FilmsService;

import jakarta.validation.Valid;

@Validated
@Service
@Qualifier("FilmsServiceImpl")
public class FilmsServiceImpl implements FilmsService {
	@Autowired
	private final FilmsRepository fRepository;
	@Autowired
	private final FilmMapper fMapper;
	@Autowired
	private final FilmsCategoryService fcService;
	@Autowired
	private final ActorsService aService;

	public FilmsServiceImpl(FilmsRepository fRepository, FilmMapper fMapper, FilmsCategoryService fcService,
			ActorsService actorService) {
		this.fRepository = fRepository;
		this.fMapper = fMapper;
		this.fcService = fcService;
		this.aService = actorService;
	}

	@Override
	public FilmsDto addFilms(@Valid FilmsDto filmDto, Integer categoryId) throws Exception {
		var fCategory = fcService.findFcById(categoryId);
		var film = fMapper.toEntity(filmDto);
		film.setFilmCategory(fCategory);
		var result = fRepository.save(film);
		return fMapper.toDto(result);
	}

	@Override
	public FilmsDto updateFilm(@Valid FilmsDto filmDto, Integer categoryId, Integer idFilm) throws Exception {
		var fcCategory = fcService.findFcById(categoryId);
		var v = getFilmById(idFilm, categoryId);
		var result1 = fMapper.toUpdate(filmDto, v);
		result1.setFilmCategory(fcCategory);
		var result = fRepository.save(result1);
		return fMapper.toDto(result);
	}

	@Override
	public void deleteFilm(Integer filmId, Integer categoryId) throws Exception {
		fRepository.deleteFilm(filmId, categoryId);

	}

	@Override
	public List<FilmsDto> getFilmsCategoryById(Integer categoryId) throws Exception {
		return fRepository.getFilmsCategoryById(categoryId);
	}

	@Override
	public Films getFilmById(Integer idFilm, Integer categoryId) throws Exception {
		return fRepository.getFilmById(idFilm, categoryId);
	}

	@Override
	public FilmsDto getFilmsById(Integer idFilm, Integer categoryId) throws Exception {
		var c = fRepository.getFilmById(idFilm, categoryId);
		var result = fMapper.toDto(c);
		return result;
	}

	@Override
	public List<FilmsDto> getFreeFilmsCategory(Integer categoryId, BigDecimal onlineCost) throws Exception {
		return fRepository.getFreeFilmsCategory(categoryId, onlineCost);
	}

	@Override
	public List<FilmsDto> getPaidFilmsCategory(Integer categoryId, BigDecimal onlineCost) throws Exception {

		return fRepository.getPaidFilmsCategory(categoryId, onlineCost);
	}

	@Override
	public List<FilmsDto> getAllFreeFilms(BigDecimal onlineCost) throws Exception {

		return fRepository.getAllFreeFilms(onlineCost);
	}

	@Override
	public List<FilmsDto> getAllPaidFilms(BigDecimal onlineCost) throws Exception {
		return fRepository.getAllPaidFilms(onlineCost);
	}

	@Override
	public List<FilmsDto> getAllFilms() throws Exception {
		return fRepository.getAllFilms();
	}

	@Override
	public List<FilmsDto> getAllFilmsByActorId(Integer actorId) throws Exception {
		var c = aService.getActor(actorId);
		List<FilmsDto> result = ((FilmsRepository) c).getAllFilms();
		return result;
	}

	@Override
	public FilmsDto getPaidFilmsByCategory(Integer idFilm, Integer categoryId) throws Exception {
		
		return fRepository.getPaidFilmsByCategory(idFilm,categoryId);
	}

	@Override
	public FilmsDto getFreeFilmsByCategory(Integer idFilm, Integer categoryId) throws Exception {
		
		return fRepository.getFreeFilmsByCategory(idFilm, categoryId);
	}

	

}
