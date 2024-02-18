package com.example.gatewayservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class FilterConfig {

//    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/first-service/**")
                        .filter(f -> f.addRequestHeader("first-request", "first-request-header")
                                      .addResponseHeader("first-response", "first-response-header"))
                        .uri("http://127.0.0.1:8081"))
                .route(r -> r.path("/second-service/**")
                        .filter(f -> f.addRequestHeader("second-request", "second-request-header")
                                .addResponseHeader("second-response", "second-response-header"))
                        .uri("http://127.0.0.1:8082"))
                .build();
    }
}
