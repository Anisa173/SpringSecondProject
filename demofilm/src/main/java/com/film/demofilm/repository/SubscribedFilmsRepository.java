package com.film.demofilm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.film.demofilm.domain.dto.SubscribedFilmDto;
import com.film.demofilm.entity.SubscribedFilm;

@Repository
public interface SubscribedFilmsRepository extends JpaRepository<SubscribedFilm, Integer> {

	@Query("SELECT c.id,f.idFilm FROM SubscribedFilm sf INNER JOIN User c ON  c.sf.customerId = c.id "
			+ "INNER JOIN Films f ON f.sf.filmId = f.idFilm  HAVING(costo) > 0  WHERE c.id=:id AND f.idFilm=:idFilm ")
	SubscribedFilm getSubscribedFilmPaidByUserId(Integer id, Integer idFilm);

	@Query("SELECT f,sf.reviews,c.fullName FROM SubscribedFilm sf INNER JOIN User c ON  c.sf.customerId = c.id "
			+ "INNER JOIN Films f ON f.sf.filmId = f.idFilm WHERE f.idFilm=:idFilm ")
	List<SubscribedFilmDto> getReviewsByFilmId(Integer idFilm);

	@Query("SELECT f,sf.reviews,c.fullName,c.id FROM SubscribedFilm sf INNER JOIN User c ON  c.sf.customerId = c.id "
			+ "INNER JOIN Films f ON f.sf.filmId = f.idFilm WHERE c.id=:id")
	List<SubscribedFilmDto> getUserReviewsById(Integer customerId);

	@Query("SELECT f.filmTitle,f.onlineCost costo,sf.reviews FROM SubscribedFilm sf INNER JOIN User c ON  c.sf.customerId = c.id "
			+ "INNER JOIN Films f ON f.sf.filmId = f.idFilm   WHERE c.id=:id AND f.idFilm=:idFilm AND costo=0")
	SubscribedFilmDto getSubscribedFreeFilmByUserId(Integer id, Integer idFilm);

	@Query("SELECT f,sf.reviews,c.fullName FROM SubscribedFilm sf INNER JOIN User c ON  c.sf.customerId = c.id "
			+ "INNER JOIN Films f ON f.sf.filmId = f.idFilm WHERE c.id=:id AND f.onlineCost=0")
	List<SubscribedFilmDto> getFreeFilmsReviewsByUserId(Integer id);

	@Query("SELECT f,sf.reviews,c.fullName,sf.onlineCost filmCost FROM SubscribedFilm sf INNER JOIN User c ON  c.sf.customerId = c.id "
			+ "INNER JOIN Films f ON f.sf.filmId = f.idFilm HAVING(filmCost)>0 WHERE c.id=:id")
	List<SubscribedFilmDto> getPaidFilmsReviewsByUserId(Integer id);

	@Query("SELECT f.filmTitle,sf.reviews ,f.onlineCost costo FROM SubscribedFilm sf INNER JOIN User c ON  c.sf.customerId = c.id "
			+ "INNER JOIN Films f ON f.sf.filmId = f.idFilm  HAVING(costo) > 0  WHERE c.id=:id AND f.idFilm=:idFilm ")
	SubscribedFilmDto getSubscribedPaidFilmByUserId(Integer id, Integer idFilm);

	@Query("Select f,c.id,c.fullName,sf.review filmReview FROM SubscribedFilm sf INNER JOIN User c ON  c.sf.customerId = c.id "
			+ "INNER JOIN Films f ON f.sf.filmId = f.idFilm  WHERE c.id=:id AND f.idFilm=:idFilm")
	SubscribedFilmDto getFilmReviewsByUserId(Integer id, Integer idFilm);

	@Query("SELECT f,sf.reviews,c.id,c.fullName FROM SubscribedFilm sf INNER JOIN User c ON  c.sf.customerId = c.id "
			+ "INNER JOIN Films f ON f.sf.filmId = f.idFilm GROUP BY f.idFilm ORDER BY c.id,f.idFilm ")
	List<SubscribedFilmDto> getSubscribedFilmById();

   @Query("SELECT f.filmUrl,c.fullName,f.onlineCost FROM SubscribedFilm sf INNER JOIN User c ON  c.sf.customerId = c.id "
		+ "INNER JOIN Films f ON f.sf.filmId = f.idFilm WHERE c.id=:id AND f.idFilm=:idFilm ")
	SubscribedFilmDto getPaidFilmByUrl(Integer id,Integer idFilm);

}