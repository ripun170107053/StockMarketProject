package com.project.ripunjoy;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class config
{
    @Configuration
    public class RequestCorsFilter {

        @Bean
        public CorsFilter corsFilter()
        {
            final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            CorsConfiguration config = new CorsConfiguration();
            config.setAllowCredentials(true);
            config.setAllowedOriginPatterns(List.of("*"));
            config.setAllowedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "responseType", "Authorization"));
            config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "OPTIONS", "DELETE", "PATCH"));
            source.registerCorsConfiguration("/**", config);
            return new CorsFilter( source);
        }

    }
}
