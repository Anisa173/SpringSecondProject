package com.film.demofilm.domain.dto;


public class UserLoginDto {
	private Integer id;
	private String email;
	private String password;
	private String jwt;

	public UserLoginDto() {
		super();
	}

	public UserLoginDto(Integer id, String email, String password, String jwt) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.jwt = jwt;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
}
