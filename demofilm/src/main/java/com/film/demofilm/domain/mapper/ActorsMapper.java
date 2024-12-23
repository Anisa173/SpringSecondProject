package com.film.demofilm.domain.mapper;

import java.util.ArrayList;
import java.util.List;

import com.film.demofilm.domain.dto.ActorsDto;
import com.film.demofilm.entity.Actors;

public class ActorsMapper extends BaseMapper<Actors, ActorsDto> {

	@Override
	public Actors toEntity(ActorsDto dto) {
		Actors actor = new Actors();
		actor.setIdAct(dto.getIdAct());
		actor.setFullName(dto.getFullName());
		actor.setBiography(dto.getBiography());
		actor.setImageUrl(dto.getImageUrl());
		actor.setGrades(dto.getGrades());
		return actor;
	}

	/*
	 * private Integer idAct; private String fullName; private String biography;
	 * private String imageUrl; private String grades; private Integer filmsId;
	 * private String filmTitle; private Integer totalFilms;
	 */

	@Override
	public ActorsDto toDto(Actors entity) {
		ActorsDto actDto = new ActorsDto();
		actDto.setIdAct(entity.getId());
		actDto.setFullName(entity.getFullName());
		actDto.setBiography(entity.getBiography());
		actDto.setImageUrl(entity.getImageUrl());
		actDto.setGrades(entity.getGrades());
		actDto.setFilmsId(((Actors) entity.getFilms()).getId());
		actDto.setFilmTitle(((ActorsDto) entity.getFilms()).getFilmTitle());
		var totalFilms = entity.getFilms().stream().count();
		actDto.setTotalFilms(totalFilms);
		return actDto;
	}

	@Override
	public Actors toUpdate(ActorsDto dto, Actors entity) {
		entity.setFullName(dto.getFullName());
		entity.setBiography(dto.getBiography());
		entity.setImageUrl(dto.getImageUrl());
		entity.setGrades(dto.getGrades());
		return entity;
	}

	@Override
	public List<Actors> toEntity(List<ActorsDto> dtoList) {
		if (dtoList == null) {
			return null;
		}

		List<Actors> actor = new ArrayList<Actors>(dtoList.size());
		for (ActorsDto actorDt : dtoList) {
			actor.add(toEntity(actorDt));

		}

		return actor;
	}

	@Override
	public List<ActorsDto> toDto(List<Actors> entityList) {
		if (entityList == null) {
			return null;
		}
		List<ActorsDto> actDt = new ArrayList<ActorsDto>(entityList.size());
		for (Actors act : entityList) {
			actDt.add(toDto(act));
		}
		return actDt;
	}

}
