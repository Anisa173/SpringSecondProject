package com.film.demofilm.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.film.demofilm.domain.dto.FilmsDto;
import com.film.demofilm.entity.Films;
import com.film.demofilm.service.FilmsService;

import jakarta.validation.Valid;

@Profile("rest")
@RestController
@RequestMapping("/api/Films")
public class FilmController {
	@Autowired
	private final FilmsService fService;

	public FilmController(FilmsService fService) {
		this.fService = fService;
	}

	@GetMapping("all")
	public ResponseEntity<List<FilmsDto>> getAllFilms() throws Exception {
		return ResponseEntity.ok(fService.getAllFilms());
	}

	@PostMapping("/create/{categoryId}")
	public ResponseEntity<FilmsDto> addFilms(@Valid @PathVariable Integer categoryId, @RequestBody FilmsDto filmDto)
			throws Exception {
		return ResponseEntity.ok(fService.addFilms(filmDto, categoryId));
	}

	@PutMapping("/update/{categoryId}/{idFilm}")
	public ResponseEntity<FilmsDto> updateFilm(@Valid @PathVariable Integer categoryId, @PathVariable Integer idFilm,
			FilmsDto filmDto) throws Exception {
		return ResponseEntity.ok(fService.updateFilm(filmDto, categoryId, idFilm));
	}

	@DeleteMapping("/delete/{categoryId}/{filmId}")
	public ResponseEntity<Void> deleteFilm(@PathVariable Integer categoryId, @PathVariable Integer filmId)
			throws Exception {
		fService.deleteFilm(filmId, categoryId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@GetMapping("/{categoryId}")
	public ResponseEntity<List<FilmsDto>> getFilmsCategoryById(@PathVariable Integer categoryId) throws Exception {
		return ResponseEntity.ok(fService.getFilmsCategoryById(categoryId));
	}

	@GetMapping("/{categoryId}/{idFilm}")
	public ResponseEntity<Films> getFilmById(@PathVariable Integer categoryId, @RequestParam Integer idFilm)
			throws Exception {
		return ResponseEntity.ok(fService.getFilmById(categoryId, idFilm));
	}

	@GetMapping("/read/{categoryId}/{idFilm}")
	public ResponseEntity<FilmsDto> getFilmsById(@PathVariable Integer categoryId, @PathVariable Integer idFilm)
			throws Exception {
		return ResponseEntity.ok(fService.getFilmsById(categoryId, idFilm));
	}

	@GetMapping("/free/{categoryId}")
	public ResponseEntity<List<FilmsDto>> getFreeFilmsCategory(@PathVariable Integer categoryId,
			@RequestParam BigDecimal onlineCost) throws Exception {
		return ResponseEntity.ok(fService.getFreeFilmsCategory(categoryId, onlineCost));
	}
	
    @GetMapping("/free/{categoryId}/{idFilm}")
	public ResponseEntity<FilmsDto> getFreeFilmsByCategory(@PathVariable Integer idFilm,@PathVariable Integer categoryId) throws Exception{
	return ResponseEntity.ok(fService.getFreeFilmsByCategory(idFilm, categoryId));
	}
	
	@GetMapping("/paid/{categoryId}/{idFilm}")
    public ResponseEntity<FilmsDto> getPaidFilmsByCategory(@PathVariable Integer idFilm,@PathVariable Integer categoryId) throws Exception{
	return ResponseEntity.ok(fService.getPaidFilmsByCategory(idFilm, categoryId));
	}
    
   /* FilmsDto getPaidFilmsByCategory(Integer idFilm, Integer categoryId) */
	@GetMapping("/paid/{categoryId}")
	public ResponseEntity<List<FilmsDto>> getPaidFilmsCategory(@PathVariable Integer categoryId,
			@RequestParam BigDecimal onlineCost) throws Exception {
		return ResponseEntity.ok(fService.getPaidFilmsCategory(categoryId, onlineCost));
	}

	@GetMapping("/all/free")
	public ResponseEntity<List<FilmsDto>> getAllFreeFilms(@RequestParam BigDecimal onlineCost) throws Exception {
		return ResponseEntity.ok(fService.getAllFreeFilms(onlineCost));
	}

	@GetMapping("/{actorId}")
	public ResponseEntity<List<FilmsDto>> getAllFilmsByActorId(@PathVariable Integer actorId) throws Exception {
		return ResponseEntity.ok(fService.getAllFilmsByActorId(actorId));
	}

	@GetMapping("/all/paid")
	public ResponseEntity<List<FilmsDto>> getAllPaidFilms(@RequestParam BigDecimal onlineCost) throws Exception {
		return ResponseEntity.ok(fService.getAllPaidFilms(onlineCost));
	}
}
