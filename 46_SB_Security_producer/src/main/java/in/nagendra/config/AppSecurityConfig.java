package in.nagendra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import lombok.SneakyThrows;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {
	
	@Bean
	@SneakyThrows
	public SecurityFilterChain securityConfig(HttpSecurity http) {
		
		http.authorizeHttpRequests(req -> {
			req.requestMatchers("/contact")
			.permitAll()
			.anyRequest()
			.authenticated();
		});
		
		return http.build();
	}

}
