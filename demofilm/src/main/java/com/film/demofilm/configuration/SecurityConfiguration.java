package com.film.demofilm.configuration;

import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.oauth2.server.resource.web.BearerTokenAuthenticationEntryPoint;
import org.springframework.security.oauth2.server.resource.web.access.BearerTokenAccessDeniedHandler;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@Profile("rest")
public class SecurityConfiguration {
	@PostConstruct
	public void init() {
		System.err.println("Security Profile Bearer");
	}

	private final RSAKeyProperties keys;

	public SecurityConfiguration(RSAKeyProperties keys) {
		this.keys = keys;
	}

	@Bean
	public AuthenticationManager authenticationManager(UserDetailsService userDetailsService,
			PasswordEncoder passwordEncoder) {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder);
		return new ProviderManager(authenticationProvider);
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests(auth -> {
			auth.requestMatchers("/api/auth/user/login").hasRole("CUSTOMER");
			auth.requestMatchers("/api/auth/user/login").hasRole("ADMIN");
			auth.requestMatchers("/api/user/register").hasRole("ADMIN");
			auth.requestMatchers("/api/user/register").hasRole("CUSTOMER");
			auth.requestMatchers("/api/user/update/{id}").hasRole("ADMIN");
			auth.requestMatchers("/api/user/update/{id}").hasRole("CUSTOMER");
			auth.requestMatchers("/api/user/all").hasRole("ADMIN");
			auth.requestMatchers("/api/user/{id}").hasRole("ADMIN");
			auth.requestMatchers("/api/user/{id}").hasRole("CUSTOMER");
			auth.requestMatchers("/api/user/delete/{id}").hasRole("ADMIN");
			auth.requestMatchers("/api/user/location/{id}").hasRole("ADMIN");
			auth.requestMatchers("/api/FilmCategory/create").hasRole("ADMIN");
			/* auth.requestMatchers("/api/FilmCategory/update/{id}").hasRole("ADMIN"); */
			auth.requestMatchers("/api/FilmCategory/read/{id}").hasAuthority("ADMIN");
			auth.requestMatchers("/api/FilmCategory/read/{id}").hasAuthority("CUSTOMER");
			auth.requestMatchers("/api/FilmCategory/delete/{id}").hasRole("ADMIN");
			auth.requestMatchers("/api/FilmCategory/all").hasRole("ADMIN");
			auth.requestMatchers("/api/FilmCategory/all").hasRole("CUSTOMER");
			auth.requestMatchers("/api/Films/all").hasAuthority("ADMIN");
			auth.requestMatchers("/api/Films/create/{categoryId}").hasRole("ADMIN");
			auth.requestMatchers("/api/Films/update/{categoryId}/{idFilm}").hasRole("ADMIN");
			auth.requestMatchers("/api/Films/delete/{categoryId}/{filmId}").hasRole("ADMIN");
			auth.requestMatchers("/api/Films/{categoryId}").hasRole("ADMIN");
			auth.requestMatchers("/api/Films/{categoryId}").hasRole("CUSTOMER");
			auth.requestMatchers("/api/Films/{categoryId}/{idFilm}").hasRole("ADMIN");
			auth.requestMatchers("/api/Films/read/{categoryId}/{idFilm}").hasRole("ADMIN");
			auth.requestMatchers("/api/Films/free/{categoryId}").hasRole("CUSTOMER");
			auth.requestMatchers("/api/Films/free/{categoryId}").hasRole("ADMIN");
			auth.requestMatchers("/api/Films/paid/{categoryId}").hasRole("ADMIN");
			auth.requestMatchers("/api/Films/paid/{categoryId}").hasRole("CUSTOMER");
			auth.requestMatchers("/api/Films/free/{categoryId}/{idFilm}").hasRole("CUSTOMER");
			auth.requestMatchers("/api/Films/free/{categoryId}/{idFilm}").hasRole("ADMIN");
			auth.requestMatchers("/api/Films/paid/{categoryId}/{idFilm}").hasRole("ADMIN");
			auth.requestMatchers("/api/Films/paid/{categoryId}/{idFilm}").hasRole("CUSTOMER");
			auth.requestMatchers("/api/Films/all/free").hasRole("ADMIN");
			auth.requestMatchers("/api/Films/all/paid").hasRole("ADMIN");
			auth.requestMatchers("/api/Films/{actorId}").hasRole("ADMIN");
			auth.requestMatchers("/api/actors/create/{categoryId}/{idFilm}").hasRole("ADMIN");
			auth.requestMatchers("/api/actors/update/{idFilm}/{actorId}").hasRole("ADMIN");
			auth.requestMatchers("/api/actors/delete/{idFilm}/{actorId}").hasRole("ADMIN");
			auth.requestMatchers("/api/actors/all").hasRole("ADMIN");
			auth.requestMatchers("/api/actors/all/{idFilm}").hasRole("ADMIN");
			auth.requestMatchers("/api/actors/retrieve/{idFilm}/actors").hasRole("ADMIN");
			auth.requestMatchers("/api/actors/retrieve/{idFilm}/actors").hasRole("CUSTOMER");
			auth.requestMatchers("/api/actors/{idFilm}/{actorId}").hasRole("ADMIN");
			auth.requestMatchers("/api/subscribedFilm/add/free/{userId}/films").hasAuthority("CUSTOMER");
			auth.requestMatchers("/api/subscribedFilm/add/paid/{userId}/films").hasAuthority("CUSTOMER");
			auth.requestMatchers("/api/subscribedFilm/paid/{id}/{idFilm}").permitAll();
			auth.requestMatchers("/api/subscribedFilm/read/paid/{id}/{idFilm}").hasAuthority("CUSTOMER");
			auth.requestMatchers("/api/subscribedFilm/read/free/{id}/{idFilm}").hasAuthority("CUSTOMER");
			auth.requestMatchers("/api/subscribedFilm/read/paid/{id}/{idFilm}").hasAuthority("ADMIN");
			auth.requestMatchers("/api/subscribedFilm/read/free/{id}/{idFilm}").hasAuthority("ADMIN");
			auth.requestMatchers("/api/subscribedFilm/read/all").hasAuthority("ADMIN");
			auth.requestMatchers("/api/subscribedFilm/read/{id}/{idFilm}").hasAuthority("ADMIN");
			auth.requestMatchers("/api/subscribedFilm/read/{id}/{idFilm}").hasAuthority("CUSTOMER");
			auth.requestMatchers("/api/subscribedFilm/reviews/{idFilm}").hasAuthority("ADMIN");
			auth.requestMatchers("/api/subscribedFilm/reviews/{id}").hasAuthority("CUSTOMER");
			auth.requestMatchers("/api/subscribedFilm/read/free/{id}").hasAuthority("CUSTOMER");
			auth.requestMatchers("/api/subscribedFilm/read/paid/{id}").hasRole("CUSTOMER");
			auth.requestMatchers("/api/subscribedFilm/live/{id}/{idFilm}").hasRole("CUSTOMER");
			auth.requestMatchers("/api/CartItem/add/**").permitAll();
			auth.requestMatchers("/api/CartItem/{ciId}/**").permitAll();
			auth.requestMatchers("/api/CartItem/all/**").permitAll();
			auth.requestMatchers("/api/cart/{id}/cartItem/paymentMethods/**").permitAll();
			auth.requestMatchers("/api/cart/{cartId}/user/cartitem/paymentMethods/**").permitAll();
			auth.requestMatchers("/api/cart/all/**").permitAll();
			auth.requestMatchers("/api/payment/{id}/paymentMethods/cart/cartitem/**").permitAll();
			auth.requestMatchers("/api/payment/{cartId}").permitAll();
			auth.requestMatchers("/api/paymentmethods/create").hasAuthority("ADMIN");
			auth.requestMatchers("/api/paymentmethods/delete/{pmId}").hasAuthority("ADMIN");
			auth.requestMatchers("/api/paymentmethods/update/{pmId}").hasAuthority("ADMIN");
			auth.requestMatchers("/api/paymentmethods/all").hasAuthority("ADMIN");
			auth.requestMatchers("/api/paymentmethods/all").hasAuthority("CUSTOMER");
			auth.requestMatchers("/api/paymentmethods/fetch/{pmId}").permitAll();
			auth.requestMatchers("/api/paymentmethods/{pmId}").hasAuthority("ADMIN");
			auth.requestMatchers("/api/paymentmethods/read/{pmId}").hasRole("ADMIN");
			auth.requestMatchers("/api/paymentMethods/read/{id}/paymentMethod").hasRole("CUSTOMER");
			auth.requestMatchers("/api/stripe/{token}/**").permitAll();
			auth.requestMatchers("/api/stripe/card").hasAuthority("CUSTOMER");
			auth.requestMatchers("/api/stripe/{customerId}/**").permitAll();
			auth.requestMatchers("/api/stripe/create-payment-intent/**").permitAll();
			auth.anyRequest().authenticated();
		}).httpBasic(withDefaults()).oauth2ResourceServer((oauth2) -> {
			oauth2.jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationConverter()));
		}).sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.exceptionHandling(
						(exceptions) -> exceptions.authenticationEntryPoint(new BearerTokenAuthenticationEntryPoint())
								.accessDeniedHandler(new BearerTokenAccessDeniedHandler()))
				.build();
	}

	@Bean
	public JwtDecoder jwtDecoder() {
		return NimbusJwtDecoder.withPublicKey(keys.getPublicKey()).build();
	}

	@Bean
	public JwtEncoder jwtEncoder() {
		JWK jwk = new RSAKey.Builder(keys.getPublicKey()).privateKey(keys.getPrivateKey()).build();
		JWKSource<SecurityContext> jwks = new ImmutableJWKSet<>(new JWKSet(jwk));
		return new NimbusJwtEncoder(jwks);

	}

	@Bean
	public JwtAuthenticationConverter jwtAuthenticationConverter() {
		JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
		jwtGrantedAuthoritiesConverter.setAuthoritiesClaimName("roles");
		jwtGrantedAuthoritiesConverter.setAuthorityPrefix("ROLE_");
		JwtAuthenticationConverter jwtAuthConverter = new JwtAuthenticationConverter();
		jwtAuthConverter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter);
		return jwtAuthConverter;
	}

}
