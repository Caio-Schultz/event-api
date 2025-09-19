package dev.caioschultz.EventClean.infra.beans;

import dev.caioschultz.EventClean.core.gateway.EventGateway;
import dev.caioschultz.EventClean.core.usecases.findbyidentifier.FindByIdentifierUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindByIdentifierConfig {

    @Bean
    public FindByIdentifierUseCaseImpl findByIdentifierUseCase(EventGateway gateway){
        return new FindByIdentifierUseCaseImpl(gateway);
    }

}
