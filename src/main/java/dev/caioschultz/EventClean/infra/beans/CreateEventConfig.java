package dev.caioschultz.EventClean.infra.beans;

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

    // Cria-se uma classe de config para dar contexto ao Spring
    // A classe CreateEventCaseImpl é como se fosse um @Service
    // No entanto, se queremos nos manter na arquitetura limpa não podemos colocar a anotation @Service
    // Apesar de que funcionaria normalmente se fizessemos isso
    // Dessa forma, fazemos uma classe de Config usando a anotation @Bean para dar contexto ao Spring
}
