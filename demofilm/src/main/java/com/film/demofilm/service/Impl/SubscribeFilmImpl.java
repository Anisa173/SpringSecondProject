package com.film.demofilm.service.Impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.film.demofilm.domain.dto.SubscribedFilmDto;
import com.film.demofilm.domain.exception.AppException;
import com.film.demofilm.domain.mapper.SubscribedFilmMapper;
import com.film.demofilm.entity.Films;
import com.film.demofilm.entity.SubscribedFilm;
import com.film.demofilm.entity.User;
import com.film.demofilm.repository.FilmsRepository;
import com.film.demofilm.repository.SubscribedFilmsRepository;
import com.film.demofilm.repository.UserRepository;
import com.film.demofilm.service.FilmsService;
import com.film.demofilm.service.SubscribedFilmsService;
import com.film.demofilm.service.UserService;

import jakarta.validation.Valid;

@Validated
@Service
public class SubscribeFilmImpl implements SubscribedFilmsService {
	@Autowired
	private final UserRepository uRepo;
	@Autowired
	private final FilmsRepository fRepo;
	@Autowired
	private final UserService uService;
	@Autowired
	private final FilmsService fService;

	@Autowired
	private final SubscribedFilmsRepository subRepository;
	@Autowired
	private final SubscribedFilmMapper subMapper;

	public SubscribeFilmImpl(UserRepository uRepo, FilmsRepository fRepo, UserService uService, FilmsService fService,
			SubscribedFilmsRepository subrepo, SubscribedFilmMapper subMapper) {
		this.uRepo = uRepo;
		this.fRepo = fRepo;
		this.uService = uService;
		this.fService = fService;
		this.subRepository = subrepo;
		this.subMapper = subMapper;
	}

	@Override
	public SubscribedFilmDto addSubscriptionFreeFilm(@Valid SubscribedFilmDto viewOnlineFilm, Integer userId,
			Integer idF, BigDecimal onlineCost, Integer categoryId) throws Exception {
		User user = uRepo.findById(userId).orElseThrow(() -> new AppException("User not exist", HttpStatus.NOT_FOUND));
		Films film = fRepo.findById(idF).orElseThrow(() -> new AppException("User not exist", HttpStatus.NOT_FOUND));
		var u = uService.findUserById(userId);
		var result = subMapper.toEntity(viewOnlineFilm);
		result.setCustomer(u);
		var f = fService.getFilmById(idF, categoryId);
		var existFilm = fService.getAllFreeFilms(onlineCost).stream().filter(a -> a.getIdFilm().equals(idF)).count();
		if (existFilm > 0) {
			result.setFilm(f);
		} else {
			throw new AppException("Subscribed film is not found ", HttpStatus.BAD_REQUEST);
		}
		var result1 = subRepository.save(result);

		return subMapper.toDto(result1);

	}

	@Override
	public SubscribedFilmDto addSubscriptionPaidFilm(@Valid SubscribedFilmDto viewOnlineFilm, Integer userId,
			Integer idF, BigDecimal onlineCost, Integer categoryId) throws Exception {
		User user = uRepo.findById(userId).orElseThrow(() -> new AppException("User not exist", HttpStatus.NOT_FOUND));
		Films film = fRepo.findById(idF).orElseThrow(() -> new AppException("User not exist", HttpStatus.NOT_FOUND));
		var u = uService.findUserById(userId);
		var result = subMapper.toEntity(viewOnlineFilm);
		result.setCustomer(u);
		var f = fService.getFilmById(idF, categoryId);
		var existFilm = fService.getAllPaidFilms(onlineCost).stream().filter(a -> a.getIdFilm().equals(idF)).count();
		if (existFilm > 0) {
			result.setFilm(f);
		} else {
			throw new AppException("Subscribed film is not found ", HttpStatus.BAD_REQUEST);
		}
		var result1 = subRepository.save(result);

		return subMapper.toDto(result1);
	}

	@Override
	public SubscribedFilm getSubscribedFilmPaidByUserId(Integer id, Integer idFilm) throws Exception {
		return subRepository.getSubscribedFilmPaidByUserId(id, idFilm);
	}

	@Override
	public List<SubscribedFilmDto> getSubscribedFilmById() throws Exception {
		return subRepository.getSubscribedFilmById();

	}

	@Override
	public List<SubscribedFilmDto> getReviewsByFilmId(Integer idFilm) throws Exception {
		return subRepository.getReviewsByFilmId(idFilm);
	}

	@Override
	public List<SubscribedFilmDto> getUserReviewsById(Integer customerId) throws Exception {
		return subRepository.getUserReviewsById(customerId);
	}

	@Override
	public SubscribedFilmDto getSubscribedFreeFilmByUserId(Integer id, Integer idFilm) {
		return subRepository.getSubscribedFreeFilmByUserId(id, idFilm);
	}

	@Override
	public List<SubscribedFilmDto> getFreeFilmsReviewsByUserId(Integer id) throws Exception {

		return subRepository.getFreeFilmsReviewsByUserId(id);
	}

	@Override
	public List<SubscribedFilmDto> getPaidFilmsReviewsByUserId(Integer id) throws Exception {

		return subRepository.getPaidFilmsReviewsByUserId(id);
	}

	@Override
	public SubscribedFilmDto getSubscribedPaidFilmByUserId(Integer id, Integer idFilm) throws Exception {

		return subRepository.getSubscribedPaidFilmByUserId(id, idFilm);
	}

	@Override
	public SubscribedFilmDto getFilmReviewsByUserId(Integer id, Integer idFilm) throws Exception {

		return subRepository.getFilmReviewsByUserId(id, idFilm);
	}

	@Override
	public SubscribedFilmDto getPaidFilmByUrl(Integer id,Integer idFilm) throws Exception {
		
		return subRepository.getPaidFilmByUrl(id,idFilm);
	}

}
