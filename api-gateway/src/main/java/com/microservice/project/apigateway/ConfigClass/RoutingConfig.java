package com.microservice.project.apigateway.ConfigClass;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

@Configuration
public class RoutingConfig {

    @Bean
    public RouteLocator getRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder.routes()
                .route(predicateSpec -> predicateSpec
                        .path("/api/product/**").and().method(HttpMethod.POST)
                        .uri("lb://product-service")) // here lb is Load Balancing
                .build();
    }
}
