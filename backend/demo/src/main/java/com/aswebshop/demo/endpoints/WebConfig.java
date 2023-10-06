package com.aswebshop.demo.endpoints;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**") // Allow all paths, you can restrict it as needed
                    .allowedOrigins("http://localhost:5173") // Allow requests from this origin
                    .allowedMethods("GET", "POST", "PUT", "DELETE") // Allow specific HTTP methods
                    .allowedHeaders("*"); // Allow all headers

    }

}
