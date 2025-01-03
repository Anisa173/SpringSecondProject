package com.film.demofilm.configuration;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.Jwt;

import com.film.demofilm.entity.User;

public class SecurityUtils {

	private SecurityUtils() {

	}

	public static String getAfterDetailsCompletedRedirectUrl() {
		User loggedUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return switch (loggedUser.getUserRole()) {
		case ADMIN -> "/admin";
		case CUSTOMER -> "/customer";
		default -> throw new IllegalArgumentException("Unexpected value: " + loggedUser.getUserRole());
		};
	}

	public static Integer getLoggedUserId() {
		var authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication != null && authentication.getPrincipal() instanceof Jwt) {
			// handle jwt profile
			return getLoggedUser();
		} else {
			// handle null authentication
			return null;
		}
	}

	public static Integer getLoggedUser() {
		var authentication = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return Integer.valueOf(authentication.getClaim("sub"));
	}

	/**
	 * Get the login of the current user.
	 *
	 * @return the login of the current user.
	 */
	public static Optional<String> getCurrentUserLogin() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		return Optional.ofNullable(Optional.ofNullable(extractPrincipal(securityContext.getAuthentication()))
				.orElseThrow(() -> new NullPointerException("null data")));
	}

	private static String extractPrincipal(Authentication authentication) {
		if (authentication == null) {
			return null;
		} else if (authentication.getPrincipal() instanceof UserDetails) {
			UserDetails user = (UserDetails) authentication.getPrincipal();
			return user.getUsername();
		} else if (authentication.getPrincipal() instanceof String) {
			return (String) authentication.getPrincipal();
		}
		return null;
	}

	/**
	 * Get the JWT of the current user.
	 *
	 * @return the JWT of the current user.
	 */
	public static Optional<String> getCurrentUserJWT() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		return Optional.ofNullable(securityContext.getAuthentication())
				.filter(authentication -> authentication.getCredentials() instanceof String)
				.map(authentication -> (String) authentication.getCredentials());
	}

	/**
	 * Checks if the current user has any of the authorities.
	 *
	 * @param authorities the authorities to check.
	 * @return true if the current user has any of the authorities, false otherwise.
	 */
	public static boolean hasCurrentUserAnyOfAuthorities(String... authorities) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return (authentication != null && getAuthorities(authentication)
				.anyMatch(authority -> Arrays.asList(authorities).contains(authority)));
	}

	/**
	 * Checks if the current user has none of the authorities.
	 *
	 * @param authorities the authorities to check.
	 * @return true if the current user has none of the authorities, false
	 *         otherwise.
	 */
	public static boolean hasCurrentUserNoneOfAuthorities(String... authorities) {
		return !hasCurrentUserAnyOfAuthorities(authorities);
	}

	/**
	 * Checks if the current user has a specific authority.
	 *
	 * @param authority the authority to check.
	 * @return true if the current user has the authority, false otherwise.
	 */
	public static boolean hasCurrentUserThisAuthority(String authority) {
		return hasCurrentUserAnyOfAuthorities(authority);
	}

	private static Stream<String> getAuthorities(Authentication authentication) {
		return authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority);
	}

}
