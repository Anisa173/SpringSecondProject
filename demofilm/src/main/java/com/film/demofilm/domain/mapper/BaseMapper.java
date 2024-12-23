package com.film.demofilm.domain.mapper;

import java.util.List;

import com.film.demofilm.entity.BaseEntity;

public abstract class BaseMapper<K extends BaseEntity<?>, T> {

	public abstract K toEntity(T dto);

	public abstract T toDto(K entity);

	public abstract K toUpdate(T dto, K entity);

	public abstract List<K> toEntity(List<T> dtoList);

	public abstract List<T> toDto(List<K> entityList);

}
