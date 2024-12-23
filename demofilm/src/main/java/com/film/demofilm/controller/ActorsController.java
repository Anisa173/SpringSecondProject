package com.film.demofilm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.film.demofilm.domain.dto.ActorsDto;
import com.film.demofilm.entity.Actors;
import com.film.demofilm.service.ActorsService;

@RestController
@RequestMapping("/api/actors")
public class ActorsController {
	@Autowired
	private final ActorsService aService;

	public ActorsController(ActorsService aService) {
		this.aService = aService;
	}

	@PostMapping("/create/{categoryId}/{idFilm}")
	public ResponseEntity<ActorsDto> create(@PathVariable Integer categoryId, @PathVariable Integer idFilm,
			@RequestBody ActorsDto actDto) throws Exception {
		return ResponseEntity.ok(aService.create(categoryId, idFilm, actDto));
	}

	@PutMapping("/update/{idFilm}/{actorsId}")
	public ResponseEntity<ActorsDto> update(@PathVariable Integer idFilm, @PathVariable Integer actorsId,
			@RequestBody ActorsDto actDto) throws Exception {

		return ResponseEntity.ok(aService.update(actDto, idFilm, actorsId));
	}

	@DeleteMapping("/delete/{idFilm}/{actorsId}")
	public ResponseEntity<Void> delete(@PathVariable Integer idFilm, @PathVariable Integer actorId) throws Exception {
		aService.delete(actorId, idFilm);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
//ALL AGJENCI ACTORS
	@GetMapping("all")
	public ResponseEntity<List<ActorsDto>> getAllActorsById() throws Exception {
		return ResponseEntity.ok(aService.getAllActorsById());
	}
//ADMIN
	@GetMapping("/{actorId}")
	public ResponseEntity<Actors> getActor(@PathVariable Integer actorId) throws Exception {

		return ResponseEntity.ok(aService.getActor(actorId));
	}

	@GetMapping("/{idFilm}/{actorId}")
	public ResponseEntity<Actors> getActorByFilmId(@PathVariable Integer idFilm, @PathVariable Integer actorId)
			throws Exception {
		return ResponseEntity.ok(aService.getActorById(actorId, idFilm));
	}

	@GetMapping("/all/{idFilm}")
	public ResponseEntity<List<ActorsDto>> getActorsByFilmId(@PathVariable Integer idFilm) throws Exception {

		return ResponseEntity.ok(aService.getActorsByFilmId(idFilm));
	}

	@GetMapping("/retrieve/{idFilm}/actors")
	public ResponseEntity<ActorsDto> getActorFilmById(@RequestParam Integer actorId, @PathVariable Integer idFilm)
			throws Exception {
		return ResponseEntity.ok(aService.getActorFilmById(actorId, idFilm));
	}

}
