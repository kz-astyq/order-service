package kz.astyq.orderservice.core.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI restaurantServiceOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Restaurant Service API")
                        .description("API for managing restaurants")
                        .version("1.0.0"));
    }
}