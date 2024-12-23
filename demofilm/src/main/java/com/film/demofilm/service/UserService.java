package com.film.demofilm.service;

import java.util.List;

import org.springframework.security.core.Authentication;

import com.film.demofilm.domain.dto.UserDto;
import com.film.demofilm.entity.User;

import jakarta.validation.Valid;

public interface UserService {

	UserDto createUserAccount(@Valid UserDto userDto) throws Exception;

	UserDto updateUserAccount(@Valid UserDto userDto, Integer id, Authentication authentication) throws Exception;

	List<UserDto> getAllUsers() throws Exception;

	UserDto getUserById(Integer Id, Authentication authentication) throws Exception;

	User findUserCartById(Integer id) throws Exception;

	void deleteCustomer(Integer Id) throws Exception;
    User findUserById(Integer id) throws Exception;

}
