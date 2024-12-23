package com.film.demofilm.configuration;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.film.demofilm.repository.UserRepository;
@Service
public class JwtUserDetailsService implements UserDetailsService  {
	 private final UserRepository userRepository;

	    public JwtUserDetailsService(UserRepository userRepository) {
	        this.userRepository = userRepository;
	    }

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		 return userRepository
	                .findByEmail(email)
	                .orElseThrow(() -> new UsernameNotFoundException("Username not found: " + email));
	    }
	}


