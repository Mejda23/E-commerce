package com.example.ecommerce.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {
        corsRegistry.addMapping("/**")
                .allowedOrigins("http://localhost:4200") // Mettez ici l'URL du domaine autorisé, sans le port si nécessaire.
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Liste des méthodes HTTP autorisées
                .allowedHeaders("*"); // Liste des en-têtes autorisés. Vous pouvez spécifier les en-têtes spécifiques nécessaires.

        // Vous pouvez également spécifier les méthodes, les en-têtes et les origines pour les points d'API spécifiques.
        // Par exemple:
        // corsRegistry.addMapping("/api/**")
        //     .allowedOrigins("http://localhost:4200")
        //     .allowedMethods("GET", "POST");
    }
}
