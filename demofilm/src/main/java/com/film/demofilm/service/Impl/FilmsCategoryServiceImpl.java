package com.film.demofilm.service.Impl;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.film.demofilm.configuration.SecurityUtils;
import com.film.demofilm.domain.dto.FilmCategoriesDto;
import com.film.demofilm.domain.exception.AppException;
import com.film.demofilm.domain.mapper.FilmCategoriesMapper;
import com.film.demofilm.entity.FilmCategories;
import com.film.demofilm.entity.User;
import com.film.demofilm.repository.FilmsCategoriesRepository;
import com.film.demofilm.service.FilmsCategoryService;
import com.film.demofilm.service.UserService;

import jakarta.validation.Valid;

@Validated
@Service
public class FilmsCategoryServiceImpl implements FilmsCategoryService {

	@Autowired
	private final FilmsCategoriesRepository fcRepo;
	@Autowired
	private final FilmCategoriesMapper fcMapper;
	@Autowired
	private final UserService userService;

	public FilmsCategoryServiceImpl(FilmsCategoriesRepository fcRepo, FilmCategoriesMapper fcMapper,
			UserService userService) {
		this.fcRepo = fcRepo;
		this.fcMapper = fcMapper;
		this.userService = userService;
	}

	@Override
	public FilmCategoriesDto addCategory(@Valid FilmCategoriesDto filmDto) throws Exception {
		var result = fcMapper.toEntity(filmDto);
		var adminId = SecurityUtils.getLoggedUserId();
		User user = userService.findUserById(adminId);
		result.setAdm(user);
		var result1 = fcRepo.save(result);
		return fcMapper.toDto(result1);
	}


	@Override
	public void delete(Integer id) throws Exception {
		fcRepo.deleteById(id);
	}

	@Override
	public List<FilmCategoriesDto> getFilmCategories() throws Exception {
		return fcRepo.findAll().stream().map(u -> fcMapper.toDto(u)).collect(Collectors.toList());
	}

	@Override
	public FilmCategories findFcById(Integer id) throws Exception {
		return fcRepo.findById(id)
				.orElseThrow(() -> new AppException("Film Categories does not exist", HttpStatus.NOT_FOUND));
	}

	@Override
	public FilmCategoriesDto getFilmCategoryById(Integer id) throws Exception {
		FilmCategories r = findFcById(id);
		return fcMapper.toDto(r);
	}

}
