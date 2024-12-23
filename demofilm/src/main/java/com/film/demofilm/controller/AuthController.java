package com.film.demofilm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.film.demofilm.configuration.AuthServiceImpl;
import com.film.demofilm.domain.dto.UserLoginDto;

@Profile("rest")
@RestController
@RequestMapping("/api/auth/user")
public class AuthController {
	@Autowired
	private final AuthServiceImpl authService;

	public AuthController(AuthServiceImpl authService) {
		this.authService = authService;
	}

	@PostMapping("/login")
	public ResponseEntity<UserLoginDto> login(String email, String password) {
		return ResponseEntity.ok(authService.login(email, password));
	}
	

}
