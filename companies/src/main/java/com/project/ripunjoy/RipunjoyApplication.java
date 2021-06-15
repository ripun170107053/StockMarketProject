package com.project.ripunjoy;

import com.project.ripunjoy.jpa.companyJPA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@SpringBootApplication
@ComponentScan(basePackages = { "com.project.ripunjoy","stockExchange","ipo","excel"} )
@EntityScan(basePackages = { "com.project.ripunjoy","stockExchange","ipo","excel"} )
@EnableJpaRepositories(basePackages = { "com.project.ripunjoy","stockExchange","ipo","excel"} )
public class RipunjoyApplication implements CommandLineRunner
{
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	companyJPA repository;

	public static void main(String[] args) {
		SpringApplication.run(RipunjoyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("User id 10001 -> {}", repository.findById(1L));
	}

	@Configuration
	@EnableWebSecurity
	public class SecurityConfig extends WebSecurityConfigurerAdapter {

//		@Override
//		protected void configure(HttpSecurity security) throws Exception
//		{
//			security.httpBasic().disable();
//
//		}
		@Override
		protected void configure(HttpSecurity http) throws Exception
		{
			http.cors().and().csrf().disable();
		}
		@Bean
		CorsConfigurationSource corsConfigurationSource() {
			CorsConfiguration configuration = new CorsConfiguration();
			configuration.setAllowedOrigins(Arrays.asList("*"));
			configuration.setAllowedMethods(Arrays.asList("*"));
			configuration.setAllowedHeaders(Arrays.asList("*"));
			configuration.setAllowCredentials(true);
			UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
			source.registerCorsConfiguration("/**", configuration);
			return source;
		}
	}


}
