package com.film.demofilm.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.film.demofilm.domain.dto.SubscribedFilmDto;
import com.film.demofilm.entity.SubscribedFilm;
import com.film.demofilm.service.SubscribedFilmsService;

@RestController
@RequestMapping("/api/subscribedFilm")
public class SubscribedFilmController {

	@Autowired
	private final SubscribedFilmsService scFilmService;

	public SubscribedFilmController(SubscribedFilmsService scFilmService) {
		this.scFilmService = scFilmService;
	}

	//Vendos reviews per 'free' films
	@PostMapping("/add/free/{userId}/films")
	public ResponseEntity<SubscribedFilmDto> addSubscriptionFreeFilm(@PathVariable Integer userId,
			@PathVariable Integer idF, @RequestParam Integer categoryId, @RequestBody SubscribedFilmDto viewOnlineFilm,
			BigDecimal onlineCost) throws Exception {
		return ResponseEntity
				.ok(scFilmService.addSubscriptionFreeFilm(viewOnlineFilm, idF, categoryId, onlineCost, userId));
	}

	//Vendos reviews per 'paid' films
	@PostMapping("/add/paid/{userId}/films")
	public ResponseEntity<SubscribedFilmDto> addSubscriptionPaidFilm(@PathVariable Integer userId,
			@RequestParam Integer idF, @RequestParam Integer categoryId, @RequestBody SubscribedFilmDto viewOnlineFilm,
			BigDecimal onlineCost) throws Exception {
		return ResponseEntity
				.ok(scFilmService.addSubscriptionPaidFilm(viewOnlineFilm, idF, categoryId, onlineCost, userId));
	}

	// Lokalizo customer qe ka paguar per te pare filmin 'x' dhe ka dhene vleresimin
	// e tij
	@GetMapping("/paid/{id}/{idFilm}")
	public ResponseEntity<SubscribedFilm> getSubscribedFilmPaidByUserId(@PathVariable Integer id,
			@PathVariable Integer idFilm) throws Exception {
		return ResponseEntity.ok(scFilmService.getSubscribedFilmPaidByUserId(id, idFilm));
	}

    //Lokalizo dhe gjenero customer qe ka shijuar filmin 'x' on-payment dhe ka dhene
	// vleresimin e
	// tij
	@GetMapping("/read/paid/{id}/{idFilm}")
	public ResponseEntity<SubscribedFilmDto> getSubscribedPaidFilmByUserId(@PathVariable Integer id,
			@PathVariable Integer idFilm) throws Exception {
		return ResponseEntity.ok(scFilmService.getSubscribedPaidFilmByUserId(id, idFilm));

	}

	// Lokalizo dhe gjenero customer qe ka shijuar filmin 'x' on-free dhe ka dhene
	// vleresimin e
	// tij
	@GetMapping("/read/free/{id}/{idFilm}")
	public ResponseEntity<SubscribedFilmDto> getSubscribedFreeFilmByUserId(@PathVariable Integer id,
			@PathVariable Integer idFilm) throws Exception {
		return ResponseEntity.ok(scFilmService.getSubscribedFreeFilmByUserId(id, idFilm));
	}

	// Admin sheh 'te gjithe filmat' per te cilet jane dhene vleresime nga usera te
	// ndryshem
	@GetMapping("read/all")
	public ResponseEntity<List<SubscribedFilmDto>> getSubscribedFilmById() throws Exception {
		return ResponseEntity.ok(scFilmService.getSubscribedFilmById());
	}

	@GetMapping("/read/{id}/{idFilm}")
	public ResponseEntity<SubscribedFilmDto> getFilmReviewsByUserId(@PathVariable Integer id,
			@PathVariable Integer idFilm) throws Exception {

		return ResponseEntity.ok(scFilmService.getFilmReviewsByUserId(id, idFilm));
	}

	// Admin---Lista e userave qe kane 'pare' dhe kane dhene 'reviews' per filmin me
	// id ~ filmId
	@GetMapping("/reviews/{idFilm}")
	public ResponseEntity<List<SubscribedFilmDto>> getReviewsByFilmId(@PathVariable Integer idFilm) throws Exception {
		return ResponseEntity.ok(scFilmService.getReviewsByFilmId(idFilm));
	}

	// Lista e filmave qe Customer sheh ne accountin e tij per te cilet ka dhene
	// vleresime ~ reviews
	@GetMapping("/reviews/{id}")
	public ResponseEntity<List<SubscribedFilmDto>> getUserReviewsById(@PathVariable Integer id) throws Exception {
		return ResponseEntity.ok(scFilmService.getUserReviewsById(id));
	}

	// Lista e filmave 'free' qe Customer sheh ne accountin e tij per te cilet ka
	// dhene
	// vleresime ~ reviews
	@GetMapping("/read/free/{id}")
	public ResponseEntity<List<SubscribedFilmDto>> getFreeFilmsReviewsByUserId(@PathVariable Integer id)
			throws Exception {
		return ResponseEntity.ok(scFilmService.getFreeFilmsReviewsByUserId(id));
	}

	// Lista e filmave 'paid' qe Customer sheh ne accountin e tij per te cilet ka
	// dhene
	// vleresime ~ reviews
	@GetMapping("/read/paid/{id}")
	public ResponseEntity<List<SubscribedFilmDto>> getPaidFilmsReviewsByUserId(@PathVariable Integer id)
			throws Exception {
		return ResponseEntity.ok(scFilmService.getPaidFilmsReviewsByUserId(id));
	}
//Merr aksesin të shohë filmin per te cilin pagoi online
	@GetMapping("/live/{id}/{idFilm}")
	public ResponseEntity<SubscribedFilmDto> getPaidFilmUrl(@PathVariable Integer id,@PathVariable Integer idFilm) throws Exception{
	return ResponseEntity.ok(scFilmService.getPaidFilmByUrl(id, idFilm));
	}
}
