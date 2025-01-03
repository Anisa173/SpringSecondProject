package com.film.demofilm.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class PersistenceConfig {
    
   public AuditorAware<Integer> auditorAware() {
        return new SecurityAuditorAwareImpl();
}

}