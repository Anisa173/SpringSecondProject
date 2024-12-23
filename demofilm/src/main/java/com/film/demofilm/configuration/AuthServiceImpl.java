package com.film.demofilm.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import com.film.demofilm.domain.dto.UserLoginDto;
import com.film.demofilm.entity.User;
import com.film.demofilm.repository.UserRepository;



@Profile("rest")
@Service
public class AuthServiceImpl {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AuthenticationManager authManager;
	@Autowired
	private TokenService tokenService;

	public AuthServiceImpl(UserRepository userRepository, AuthenticationManager authManager, TokenService tokenService) {
		this.userRepository = userRepository;
		this.authManager = authManager;
		this.tokenService = tokenService;
	}

	public UserLoginDto login(String email, String password) {
		try {
			Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
			String token = tokenService.generateJwt(auth);
			User user = userRepository.findByEmail(email).orElse(null);
			if (user != null) {
				return new UserLoginDto(user.getId(), email, password, token);
			} else {
				return new UserLoginDto(null, null, null, null);
			}
		} catch (AuthenticationException e) {
			return new UserLoginDto(null, null, null, null);
		}
	}


}


 
