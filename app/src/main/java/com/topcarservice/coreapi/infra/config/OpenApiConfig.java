package com.topcarservice.coreapi.infra.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class OpenApiConfig {
    
    @Bean
    OpenAPI customOpenAPI(@Value("${info.app.name}") String appDesciption, 
    		@Value("${info.app.version}") String appVersion) {
        return new OpenAPI()
        	.info(new io.swagger.v3.oas.models.info.Info()
        			.title(appDesciption)
					.version(appVersion)
					.description("API para gerenciamento de clientes e serviços de carros"))
            .addSecurityItem(new SecurityRequirement().addList("BearerAuth"))
            .components(new Components()
                .addSecuritySchemes("BearerAuth", new SecurityScheme()
                    .name("BearerAuth")
                    .type(SecurityScheme.Type.HTTP)
                    .scheme("bearer")
                    .bearerFormat("JWT")));
    }
}
