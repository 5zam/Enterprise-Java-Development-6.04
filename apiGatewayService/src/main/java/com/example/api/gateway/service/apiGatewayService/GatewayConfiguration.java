package com.example.api.gateway.service.apiGatewayService;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {
    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()

                // Movie info Service
                .route(p -> p.path("/students/**")
                        .uri("lb://STUDENT-INFO-SERVICE"))

                // Rating data Service
                .route(p -> p.path("/grades**")
                        .uri("lb://GRADES-DATA-SERVICE"))
                .route(p -> p.path("/courses/**")
                        .uri("lb://GRADES-DATA-SERVICE"))

                // Movie catalog Service
                .route(p -> p.path("/catalogs/**")
                        .uri("lb://STUDENT-CATALOG-SERVICE"))

                .build();
    }
}
