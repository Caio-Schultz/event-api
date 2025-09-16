package dev.caioschultz.EventClean.infra.beans;

import dev.caioschultz.EventClean.core.gateway.EventGateway;
import dev.caioschultz.EventClean.core.usecases.findall.FindAllEventUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindAllEventsConfig {

    @Bean
    public FindAllEventUseCaseImpl findAllEventCase(EventGateway gateway){
        return new FindAllEventUseCaseImpl(gateway);

    }

}
