package com.film.demofilm.domain.mapper;


import java.util.ArrayList;
import java.util.List;

import com.film.demofilm.domain.dto.FilmsDto;
import com.film.demofilm.entity.Films;

public class FilmMapper extends BaseMapper<Films, FilmsDto> {

	@Override
	public Films toEntity(FilmsDto dto) {
		Films film = new Films();
		film.setIdFilm(dto.getIdFilm());
		film.setFilmTitle(dto.getFilmTitle());
		film.setDescription(dto.getDescription());
		film.setReleaseDate(dto.getReleaseDate());
		film.setTrialUrl(dto.getTrialUrl());
		film.setFilmUrl(dto.getFilmUrl());
		film.setMovieDuration(dto.getMovieDuration());
		film.setOnlineCost(dto.getOnlineCost());
		film.setFilmSponsor(dto.getFilmSponsor());
		return film;
	}


	@Override
	public FilmsDto toDto(Films entity) {
		FilmsDto film = new FilmsDto();
		film.setIdFilm(entity.getId());
		film.setFilmTitle(entity.getFilmTitle());
		film.setDescription(entity.getDescription());
		film.setReleaseDate(entity.getReleaseDate());
		film.setTrialUrl(entity.getTrialUrl());
		film.setFilmUrl(entity.getFilmUrl());
		film.setMovieDuration(entity.getMovieDuration());
		film.setOnlineCost(entity.getOnlineCost());
		film.setFilmSponsor(entity.getFilmSponsor());
		film.setCategoryId(entity.getFilmCategory().getId());
		film.setCategoryName(entity.getFilmCategory().getCategoryName());
		film.setAdminId(entity.getAdmin().getId());
		var totalActors = entity.getActors().stream().count();
		film.setTotalActors(totalActors);
		var totalSubscriptionFilms = entity.getSbcFilm().stream().count();
		film.setTotalSubscriptionFilms(totalSubscriptionFilms);
		return film;
	}

	@Override
	public Films toUpdate(FilmsDto entity, Films film) {
		film.setFilmTitle(entity.getFilmTitle());
		film.setDescription(entity.getDescription());
		film.setReleaseDate(entity.getReleaseDate());
		film.setTrialUrl(entity.getTrialUrl());
		film.setFilmUrl(entity.getFilmUrl());
		film.setMovieDuration(entity.getMovieDuration());
		film.setOnlineCost(entity.getOnlineCost());
		film.setFilmSponsor(entity.getFilmSponsor());
		return film;
	}

	@Override
	public List<Films> toEntity(List<FilmsDto> dtoList) {
		if (dtoList == null) {
			return null;
		}
		List<Films> films = new ArrayList<Films>(dtoList.size());
		for (FilmsDto fDto : dtoList) {
			films.add(toEntity(fDto));
		}
		return films;
	}

	@Override
	public List<FilmsDto> toDto(List<Films> entityList) {
		if (entityList == null) {
			return null;
		}

		List<FilmsDto> film = new ArrayList<FilmsDto>(entityList.size());
		for (Films fm : entityList) {
			film.add(toDto(fm));
		}
		return film;
	}

}
