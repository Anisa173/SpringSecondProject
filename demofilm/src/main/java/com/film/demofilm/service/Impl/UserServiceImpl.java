package com.film.demofilm.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.film.demofilm.domain.dto.UserDto;
import com.film.demofilm.domain.exception.AppException;
import com.film.demofilm.domain.mapper.UserMapper;
import com.film.demofilm.entity.User;
import com.film.demofilm.repository.UserRepository;
import com.film.demofilm.service.UserService;

import jakarta.validation.Valid;

@Validated
@Service
public class UserServiceImpl implements UserDetailsService, UserService {
	@Autowired
	private UserRepository uRepository;
	@Autowired
	private PasswordEncoder passEncoder;
	@Autowired
	private UserMapper uMapper;

	public UserServiceImpl(UserRepository uRepository, PasswordEncoder passEncoder, UserMapper uMapper) {
		this.uRepository = uRepository;
		this.passEncoder = passEncoder;
		this.uMapper = uMapper;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		return uRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("Email not found: " + email));

	}

	@Override
	public UserDto createUserAccount(@Valid UserDto userDto) throws Exception {
		userDto.setPassword(passEncoder.encode(userDto.getPassword()));
		var result = uMapper.toEntity(userDto);
		return uMapper.toDto(uRepository.save(result));
	}

	@Override
	public UserDto updateUserAccount(@Valid UserDto userDto, Integer id, Authentication authentication)
			throws Exception {
		var entity = uMapper.toEntity(getUserById(id, authentication));
		var result = uMapper.toUpdate(userDto, entity);
		return uMapper.toDto(uRepository.save(result));
	}

	@Override
	public List<UserDto> getAllUsers() throws Exception {
		return uRepository.findAll().stream().map(u -> uMapper.toDto(u)).collect(Collectors.toList());
	}

	@Override
	public UserDto getUserById(Integer Id, Authentication authentication) throws Exception {
		User user = uRepository.findById(Id)
				.orElseThrow(() -> new AppException("User not found", HttpStatus.NOT_FOUND));
		if (!user.getEmail().equals(authentication.getName())) {
			throw new AppException("Access denied!", HttpStatus.BAD_REQUEST);
		}
		return uMapper.toDto(user);
	}

	@Override
	public void deleteCustomer(Integer Id) throws Exception {
		uRepository.deleteCustomer(Id);

	}

	@Override
	public User findUserCartById(Integer id) throws Exception {

		return uRepository.findUserCartById(id);
	}

	@Override
	public User findUserById(Integer id) throws Exception {
		
		return uRepository.findById(id).orElseThrow(()->new AppException("User not exist",HttpStatus.NOT_FOUND));
	}

	

}
