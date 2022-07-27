package com.example.computer_sim_backend;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ComputerSimBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComputerSimBackendApplication.class, args);

	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:63342/**");
				registry.addMapping("/**").allowedMethods("*");
			}
		};
	}

	@Configuration
	public static class PersistenceHibernateConfig{
		@Bean
		public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
			return new PersistenceExceptionTranslationPostProcessor();
		}
	}

}
