package com.example.hp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;

@Configuration
@EnableWebSecurity
public class OAuth2ResourceServerSecurityConfiguration {
	
	@Value("${spring.security.oauth2.resourceserver.jwt.jwk-set-uri}")
	String jwkSetUri;

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.authorizeHttpRequests((authorize) -> authorize
						//.requestMatchers("/personagens/filtro**").permitAll()
						.anyRequest().authenticated()
					//.anyRequest().permitAll()
				)
				.oauth2ResourceServer((oauth2) -> oauth2
						 .jwt(jwt -> jwt
				                    .jwtAuthenticationConverter(jwtAuthenticationConverter())
				                )
						
			                    
				);
		return http.build();
	}
	
	private JwtAuthenticationConverter jwtAuthenticationConverter() {
	    JwtAuthenticationConverter jwtConverter = new JwtAuthenticationConverter();
	    jwtConverter.setJwtGrantedAuthoritiesConverter(jwt -> {
	        Collection<GrantedAuthority> authorities = new ArrayList<>();

	        Map<String, Object> resourceAccess = jwt.getClaim("resource_access");
	        if (resourceAccess != null && resourceAccess.containsKey("frontend-client")) {
	            Map<String, Object> clientAccess = (Map<String, Object>) resourceAccess.get("frontend-client");
	            List<String> roles = (List<String>) clientAccess.get("roles");

	            if (roles != null) {
	                for (String role : roles) {
	                    authorities.add(new SimpleGrantedAuthority("ROLE_" + role)); // ou sem ROLE_ se preferir
	                }
	            }
	        }

	        return authorities;
	    });
	    return jwtConverter;
	}
	
	@Bean
	JwtDecoder jwtDecoder() {
		return NimbusJwtDecoder.withJwkSetUri(this.jwkSetUri).build();
	}
}
