package com.film.demofilm.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.film.demofilm.domain.dto.FilmsDto;
import com.film.demofilm.entity.Films;

@Repository
public interface FilmsRepository extends JpaRepository<Films, Integer> {

	@Query("Select f.idFilm , fc.idCtg From FilmCategories fc INNER JOIN Film f ON fc.f.categoryId = fc.idCtg Where fc.idCtg =: idCtg AND f.idFilm=:categoryId")
	Films getFilmById(Integer idFilm, Integer categoryId);

	@Query("Delete From Films f INNER JOIN FilmCategories fc ON fc.f.categoryId = fc.idCtg Where f.idFilm =: idFilm AND fc.idCtg=:idCtg")
	void deleteFilm(Integer filmId, Integer categoryId);

	@Query("Select f From Films f INNER JOIN FilmCategories fc ON fc.f.categoryId = fc.idCtg Where fc.idCtg=: idCtg")
	List<FilmsDto> getFilmsCategoryById(Integer categoryId);

	@Query("Select f From Films f Inner Join FilmCategories fc ON fc.f.categoryId = fc.idCtg Where fc.idCtg=:idCtg AND f.onlineCost = 0 ")
	List<FilmsDto> getFreeFilmsCategory(Integer categoryId, BigDecimal onlineCost);

	@Query("SELECT f,f.onlineCost cost FROM Films f INNER JOIN FilmCategories fc ON fc.f.categoryId = fc.idCtg HAVING(cost)>0  WHERE fc.idCtg=:idCtg ")
	List<FilmsDto> getPaidFilmsCategory(Integer categoryId, BigDecimal onlineCost);

	@Query("SELECT f , fc.categoryName cName FROM Films f INNER JOIN FilmCategories fc ON fc.f.categoryId = fc.idCtg WHERE f.onlineCost = 0")
	List<FilmsDto> getAllFreeFilms(BigDecimal onlineCost);

	@Query("SELECT f , fc FROM Films f INNER JOIN FilmCategories fc ON fc.f.categoryId = fc.idCtg GROUP BY fc.categoryName ORDER BY f.filmTitle ")
	List<FilmsDto> getAllFilms();

	@Query("SELECT f,f.onlineCost shikoOnline , fc.categoryName FROM Films f INNER JOIN FilmCategories fc ON fc.f.categoryId = fc.idCtg GROUP BY fc.categoryName ORDER BY fc.categoryName HAVING(shikoOnline) > 0 ")
	List<FilmsDto> getAllPaidFilms(BigDecimal onlineCost);

	@Query("SELECT f From Films f INNER JOIN FilmCategories fc ON fc.f.categoryId = fc.idCtg WHERE f.idFilm=:idFilm and fc.idCtg=:categoryId HAVING(f.onlineCost)> 0")
	FilmsDto getPaidFilmsByCategory(Integer idFilm, Integer categoryId);

	@Query("SELECT f From Films f INNER JOIN FilmCategories fc ON fc.f.categoryId = fc.idCtg WHERE f.idFilm=:idFilm and dc.idCtg=:categoryId And f.onlineCost = 0")
	FilmsDto getFreeFilmsByCategory(Integer idFilm, Integer categoryId);
    
	
}
