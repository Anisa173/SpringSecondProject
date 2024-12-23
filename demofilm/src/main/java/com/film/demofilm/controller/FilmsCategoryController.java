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
import org.springframework.web.bind.annotation.RestController;

import com.film.demofilm.domain.dto.FilmCategoriesDto;
import com.film.demofilm.entity.FilmCategories;
import com.film.demofilm.service.FilmsCategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/FilmCategory")
public class FilmsCategoryController {
	@Autowired
	private final FilmsCategoryService fCategoryService;

	public FilmsCategoryController(FilmsCategoryService fCategoryService) {
		this.fCategoryService = fCategoryService;
	}

	@PostMapping("/create")
	public ResponseEntity<FilmCategoriesDto> addCategory(@Valid @RequestBody FilmCategoriesDto filmDto)
			throws Exception {
		return ResponseEntity.ok(fCategoryService.addCategory(filmDto));
	}

	/*
	 * @PutMapping("/update/{id}") public ResponseEntity<FilmCategoriesDto>
	 * updateName(@Valid @PathVariable Integer id,@RequestBody FilmCategoriesDto dto) 
	 * throws Exception { return
	 * ResponseEntity.ok(fCategoryService.updateName(dto, id)); }
	 */

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
		fCategoryService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@GetMapping("all")
	public ResponseEntity<List<FilmCategoriesDto>> getFilmCategories() throws Exception {
		return ResponseEntity.ok(fCategoryService.getFilmCategories());
	}

	@GetMapping("/{id}")
	public ResponseEntity<FilmCategories> findFcById(@PathVariable Integer id) throws Exception {

		return ResponseEntity.ok(fCategoryService.findFcById(id));
	}

	@GetMapping("/read/{id}")
	public ResponseEntity<FilmCategoriesDto> getFilmCategoryById(@PathVariable Integer id) throws Exception {
		return ResponseEntity.ok(fCategoryService.getFilmCategoryById(id));
	}

}
