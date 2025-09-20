package dev.caioschultz.EventClean.infra.beans;

import dev.caioschultz.EventClean.core.gateway.EventGateway;
import dev.caioschultz.EventClean.core.usecases.findbyid.FindEventByIdUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindByIdConfig {

    @Bean
    public FindEventByIdUseCaseImpl findEventByIdUseCase(EventGateway gateway){
        return new FindEventByIdUseCaseImpl(gateway);
    }

}
