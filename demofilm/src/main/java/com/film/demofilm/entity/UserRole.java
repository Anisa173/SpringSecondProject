package com.film.demofilm.entity;

import java.util.Arrays;

public enum UserRole {
	CUSTOMER("Customer"), ADMIN("Admin");

	private String valueRole;

	UserRole(String value) {
		this.valueRole = value;
	}

	public static UserRole fromValue(UserRole userRole) {
		return Arrays.asList(UserRole.values()).stream().filter(e -> userRole.equals(userRole)).findFirst()
				.orElseThrow(() -> new RuntimeException(String.format("User's Role %s not found", userRole)));
	}

	public String getValueRole() {
		return valueRole;
	}

	public void setValueRole(String value) {
		this.valueRole = value;
	}

}

/*
 * public static UserRole fromValue1(String role) { 
 * List<UseRole> userRole =Arrays.asList(UserRole.values());
 * UserRole toReturnEnum = null;
 * for(UserRole u : userRole) {
 * if(u.value.equals(role)) {
 * toReturnEnum =u;
 *  break; } 
 * else if(toReturnEnum==null) { 
 * new RuntimeException(String.format("User's Role not found",role)); } }
 * return toReturnEnum; }
 */
