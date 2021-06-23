package com.project.ripunjoy;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class config
{
    @Configuration
    public class RequestCorsFilter {

//        @Bean
//        public CorsFilter corsFilter()
//        {
//            final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//            CorsConfiguration config = new CorsConfiguration();
//            config.setAllowCredentials(true);
//            config.setAllowedOriginPatterns(List.of("*"));
//            config.setAllowedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "responseType", "Authorization"));
//            config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "OPTIONS", "DELETE", "PATCH"));
//            source.registerCorsConfiguration("/**", config);
//            return new CorsFilter( source);
//        }
        @Bean
        public WebMvcConfigurer corsConfigurer() {
            return new WebMvcConfigurer() {
                @Override
                public void addCorsMappings(CorsRegistry registry) {
                    //this is done to avoid cors while testing locally in addition to annotation at method level
                    registry.addMapping("/setuserapi").allowedOrigins("https://reactphase3ripun.herokuapp.com");
                    registry.addMapping("/setuserapi2").allowedOrigins("https://reactphase3ripun.herokuapp.com");
                    registry.addMapping("/getcompanies?name=").allowedOrigins("https://reactphase3ripun.herokuapp.com");
                    registry.addMapping("/addstockprices").allowedOrigins("https://reactphase3ripun.herokuapp.com");
                    registry.addMapping("/getstockprices").allowedOrigins("https://reactphase3ripun.herokuapp.com");
                }

            };
        }

    }
}
