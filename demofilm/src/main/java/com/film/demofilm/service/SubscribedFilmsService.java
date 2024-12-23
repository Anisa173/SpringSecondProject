package com.film.demofilm.service;

import java.math.BigDecimal;
import java.util.List;

import com.film.demofilm.domain.dto.SubscribedFilmDto;
import com.film.demofilm.entity.SubscribedFilm;

import jakarta.validation.Valid;

public interface SubscribedFilmsService {

	SubscribedFilmDto addSubscriptionFreeFilm(@Valid SubscribedFilmDto viewOnlineFilm, Integer userId, Integer idF,
			BigDecimal onlineCost, Integer categoryId) throws Exception;

	SubscribedFilmDto addSubscriptionPaidFilm(@Valid SubscribedFilmDto viewOnlineFilm, Integer userId, Integer idF,
			BigDecimal onlineCost, Integer categoryId) throws Exception;

	SubscribedFilm getSubscribedFilmPaidByUserId(Integer id, Integer idFilm) throws Exception;

	SubscribedFilmDto getSubscribedPaidFilmByUserId(Integer id, Integer idFilm) throws Exception;

	SubscribedFilmDto getSubscribedFreeFilmByUserId(Integer id, Integer idFilm);

	List<SubscribedFilmDto> getSubscribedFilmById() throws Exception;

	SubscribedFilmDto getFilmReviewsByUserId(Integer id, Integer idFilm) throws Exception;

	List<SubscribedFilmDto> getReviewsByFilmId(Integer idFilm) throws Exception;

	List<SubscribedFilmDto> getUserReviewsById(Integer id) throws Exception;

	List<SubscribedFilmDto> getFreeFilmsReviewsByUserId(Integer id) throws Exception;

	List<SubscribedFilmDto> getPaidFilmsReviewsByUserId(Integer id) throws Exception;

	SubscribedFilmDto getPaidFilmByUrl(Integer id,Integer idFilm) throws Exception;

}
