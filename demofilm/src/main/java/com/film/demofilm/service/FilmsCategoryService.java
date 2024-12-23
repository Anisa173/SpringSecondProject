package com.film.demofilm.service;

import java.util.List;

import com.film.demofilm.domain.dto.FilmCategoriesDto;
import com.film.demofilm.entity.FilmCategories;

import jakarta.validation.Valid;

public interface FilmsCategoryService {

	FilmCategoriesDto addCategory(@Valid FilmCategoriesDto filmDto) throws Exception;

	void delete(Integer id) throws Exception;

	List<FilmCategoriesDto> getFilmCategories() throws Exception;

	FilmCategories findFcById(Integer id) throws Exception;

	FilmCategoriesDto getFilmCategoryById(Integer idCtg) throws Exception;
}
