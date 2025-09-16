package dev.caioschultz.EventClean.infra.beans;

import dev.caioschultz.EventClean.core.gateway.EventGateway;
import dev.caioschultz.EventClean.core.usecases.findall.FindAllEventCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindAllEventsConfig {

    @Bean
    public FindAllEventCaseImpl findAllEventCase(EventGateway gateway){
        return new FindAllEventCaseImpl(gateway);

    }

}
