package com.film.demofilm.domain.mapper;

import java.util.ArrayList;
import java.util.List;
import com.film.demofilm.domain.dto.UserDto;
import com.film.demofilm.entity.User;
import com.film.demofilm.entity.UserRole;

import jakarta.validation.Valid;

public class UserMapper extends BaseMapper<User, UserDto> {

	@Override
	public User toEntity(UserDto user) {
		User user1 = new User();
		user1.setId(user.getId());
		user1.setFullName(user.getFullName());
		user1.setEmail(user.getEmail());
		user1.setPassword(user.getPassword());
		user1.setTelephoneNo(user.getTelephoneNo());
		user1.setAddress(user.getAddress());
		user1.setGender(user.getGender());
		user1.setPersonalIdentityNo(user.getPersonalIdentityNo());
		user1.setAge(user.getAge());
		user1.setUserRole(UserRole.fromValue(user.getUserRole()));
		return user1;
	}

	@Override
	public UserDto toDto(User result) {
		UserDto userDto = new UserDto();
		userDto.setId(result.getId());
		userDto.setFullName(result.getFullName());
		userDto.setAddress(result.getAddress());
		userDto.setTelephoneNo(result.getTelephoneNo());
		userDto.setEmail(result.getEmail());
		userDto.setPassword(result.getPassword());
		userDto.setPersonalIdentityNo(result.getPersonalIdentityNo());
		userDto.setAge(result.getAge());
		userDto.setUserRole(UserRole.fromValue(result.getUserRole()));
		var totalFilms = result.getFilm().stream().count();
		userDto.setTotalFilms(totalFilms);
		var totalFilmCategories = result.getFilmCategory().stream().count();
		userDto.setTotalFilmCategories(totalFilmCategories);
		var totalSubscribedFilm = result.getSubscFilm().stream().count();
		userDto.setTotalSubscribedFilm(totalSubscribedFilm);
		var totalUserCards = result.getCards().stream().count();
		userDto.setTotalUserCards(totalUserCards);
		userDto.setLogin(result.getLogin());
		var totalCarts = result.getCarts().stream().count();
		userDto.setTotalCarts(totalCarts);
		var totalCustomers = result.getCustomer().stream().count();
		userDto.setTotalCustomers(totalCustomers);
		userDto.setAdminId(result.getAdmin().getId());
		var totalPaymentMethods = result.getPm().stream().count();
		userDto.setTotalPaymentMethods(totalPaymentMethods);
		return userDto;
	}

	@Override
	public User toUpdate(@Valid UserDto userDto, User entity) {
		entity.setAddress(userDto.getAddress());
		entity.setTelephoneNo(userDto.getTelephoneNo());
		entity.setEmail(userDto.getEmail());
		entity.setPassword(userDto.getPassword());
		entity.setPersonalIdentityNo(userDto.getPersonalIdentityNo());
		return entity;
	}

	@Override
	public List<User> toEntity(List<UserDto> dtoList) {
		if (dtoList == null) {
			return null;
		}

		List<User> list = new ArrayList<User>(dtoList.size());
		for (UserDto userDto : dtoList) {
			list.add(toEntity(userDto));
		}

		return list;
	}

	@Override
	public List<UserDto> toDto(List<User> entityList) {
		if (entityList == null) {
			return null;
		}

		List<UserDto> list = new ArrayList<UserDto>(entityList.size());
		for (User user : entityList) {
			list.add(toDto(user));
		}

		return list;
	}

}
