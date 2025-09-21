package dev.caioschultz.EventClean.infra.beans;

import dev.caioschultz.EventClean.core.gateway.EventGateway;
import dev.caioschultz.EventClean.core.usecases.delete.DeleteEventByIdUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteByIdConfig {

    @Bean
    public DeleteEventByIdUseCaseImpl deleteEventByIdUseCase(EventGateway gateway){
        return new DeleteEventByIdUseCaseImpl(gateway);
    }
}
