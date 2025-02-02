package com.olky.exchangerateservice;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {


    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()  // Utilisation correcte de la classe Info
                        .title("API Documentation")
                        .version("1.0")
                        .description("Documentation for the API"));
    }
}
