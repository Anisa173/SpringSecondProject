package com.film.demofilm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.film.demofilm.domain.dto.UserDto;
import com.film.demofilm.entity.User;
import com.film.demofilm.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private final UserService uService;

	public UserController(UserService uService) {
		this.uService = uService;
	}

	@PostMapping("/register")
	public ResponseEntity<UserDto> createUserAccount(@Valid @RequestBody UserDto userDto) throws Exception {
		return ResponseEntity.ok(uService.createUserAccount(userDto));
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<UserDto> updateUserAccount(@Valid @PathVariable Integer id, @RequestBody UserDto userDto,
			Authentication authentication) throws Exception {
		return ResponseEntity.ok(uService.updateUserAccount(userDto, id, authentication));
	}

	@GetMapping("all")
	public ResponseEntity<List<UserDto>> getAllUsers() throws Exception {
		return ResponseEntity.ok(uService.getAllUsers());
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Integer Id, Authentication authentication)
			throws Exception {
		return ResponseEntity.ok(uService.getUserById(Id, authentication));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteCustomer(Integer id) throws Exception {
		uService.deleteCustomer(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@GetMapping("/location/{id}")
	public ResponseEntity<User> findUserById(Integer id) throws Exception {
		return ResponseEntity.ok(uService.findUserById(id));

	}

}
