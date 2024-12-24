package in.nagendra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.nagendra.security.AppSecurity;

@Configuration
public class AppConfig {

	public AppConfig() {
		System.out.println("Configuraton :: Constructor");
	}
	@Bean
	public AppSecurity getInstance() {
		return new AppSecurity();
	}

}
