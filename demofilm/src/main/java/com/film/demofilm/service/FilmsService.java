package com.film.demofilm.service;

import java.math.BigDecimal;
import java.util.List;

import com.film.demofilm.domain.dto.FilmsDto;
import com.film.demofilm.entity.Films;

import jakarta.validation.Valid;

public interface FilmsService {

	List<FilmsDto> getAllFilms() throws Exception;

	FilmsDto addFilms(@Valid FilmsDto filmDto, Integer categoryId) throws Exception;

	FilmsDto updateFilm(@Valid FilmsDto filmDto, Integer categoryId, Integer idFilm) throws Exception;

	void deleteFilm(Integer filmId, Integer categoryId) throws Exception;

	List<FilmsDto> getFilmsCategoryById(Integer categoryId) throws Exception;

	Films getFilmById(Integer idFilm, Integer categoryId) throws Exception;

	List<FilmsDto> getFreeFilmsCategory(Integer categoryId,BigDecimal onlineCost) throws Exception;

	List<FilmsDto> getPaidFilmsCategory(Integer categoryId,BigDecimal onlineCost) throws Exception;

    FilmsDto getPaidFilmsByCategory(Integer idFilm, Integer categoryId) throws Exception;
	
    FilmsDto getFreeFilmsByCategory(Integer idFilm, Integer categoryId) throws Exception;
    
    List<FilmsDto> getAllFreeFilms(BigDecimal onlineCost) throws Exception;

	FilmsDto getFilmsById(Integer idFilm, Integer categoryId) throws Exception;
	
	List<FilmsDto> getAllFilmsByActorId(Integer actorId) throws Exception;

	List<FilmsDto> getAllPaidFilms(BigDecimal onlineCost) throws Exception;

	
}
