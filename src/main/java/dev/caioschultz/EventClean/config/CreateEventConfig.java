package dev.caioschultz.EventClean.config;

import dev.caioschultz.EventClean.core.usecases.create.CreateEventCaseImpl;
import dev.caioschultz.EventClean.infra.gateway.EventRepositoryGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateEventConfig {

    @Bean
    public CreateEventCaseImpl createEventCase(EventRepositoryGateway gateway){
        return new CreateEventCaseImpl(gateway);
    }
}
