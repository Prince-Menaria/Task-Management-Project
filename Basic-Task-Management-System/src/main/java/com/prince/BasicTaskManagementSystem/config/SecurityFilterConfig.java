package com.prince.BasicTaskManagementSystem.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.prince.BasicTaskManagementSystem.filter.JWTAuthenticationFilter;
import com.prince.BasicTaskManagementSystem.filter.JwtAuthenticationEntryPoint;

@Configuration
@AllArgsConstructor
public class SecurityFilterConfig {

	private JwtAuthenticationEntryPoint point;
	private JWTAuthenticationFilter filter;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
		return security.csrf(csrf -> csrf.disable()).cors(cors -> cors.disable())
				.authorizeHttpRequests(
						auth -> auth.requestMatchers("/authenticate", "/h2-console/**").permitAll().anyRequest().authenticated())
				.headers(headers -> headers.frameOptions(frameOption -> frameOption.sameOrigin()))
				.exceptionHandling(ex -> ex.authenticationEntryPoint(point))
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class).build();

	}

}
