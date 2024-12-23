package com.film.demofilm.domain.mapper;

import java.util.List;

import com.film.demofilm.domain.dto.FilmCategoriesDto;
import com.film.demofilm.entity.FilmCategories;

import jakarta.validation.Valid;

public class FilmCategoriesMapper extends BaseMapper<FilmCategories, FilmCategoriesDto> {

	@Override
	public FilmCategories toEntity(FilmCategoriesDto dto) {
		FilmCategories fCat = new FilmCategories();
		fCat.setIdCtg(dto.getIdCtg());
		fCat.setCategoryName(dto.getCategoryName());
		return fCat;
	}

	/*
	 * private Integer idCtg; private String categoryName; private Integer adminId;
	 * private Integer totalFilms;
	 */

	@Override
	public FilmCategoriesDto toDto(FilmCategories entity) {
		FilmCategoriesDto fDto = new FilmCategoriesDto();
		fDto.setIdCtg(entity.getId());
		fDto.setCategoryName(entity.getCategoryName());
		fDto.setAdminId(entity.getAdm().getId());
		var totalFilms = entity.getFilm().stream().count();
		fDto.setTotalFilms(totalFilms);
		return fDto;
	}

	@Override
	public FilmCategories toUpdate(@Valid FilmCategoriesDto dto, FilmCategories entity) {
		entity.setCategoryName(dto.getCategoryName());
		return entity;
	}

	@Override
	public List<FilmCategories> toEntity(List<FilmCategoriesDto> dtoList) {
		
		return null;
	}

	@Override
	public List<FilmCategoriesDto> toDto(List<FilmCategories> entityList) {
		
		return null;
	}

}
