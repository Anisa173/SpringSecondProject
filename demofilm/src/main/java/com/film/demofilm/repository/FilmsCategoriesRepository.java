package com.film.demofilm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.film.demofilm.entity.FilmCategories;

@Repository
public interface FilmsCategoriesRepository extends JpaRepository<FilmCategories, Integer> {

	FilmCategories addCategory(FilmCategories entity);

}
