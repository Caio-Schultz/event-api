package dev.caioschultz.EventClean.infra.gateway;

import dev.caioschultz.EventClean.core.entities.Event;
import dev.caioschultz.EventClean.core.gateway.EventGateway;
import dev.caioschultz.EventClean.infra.exceptions.EventNotFoundException;
import dev.caioschultz.EventClean.infra.exceptions.UniqueConstraintViolationException;
import dev.caioschultz.EventClean.infra.mapper.EventEntityMapper;
import dev.caioschultz.EventClean.infra.persistence.EventEntity;
import dev.caioschultz.EventClean.infra.persistence.EventRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Component
@RequiredArgsConstructor
public class EventRepositoryGateway implements EventGateway {

    private final EventRepository repository;
    private final EventEntityMapper eventEntityMapper;

    @Override
    public Event createEvent(Event event) {

        String identifier = createRandomIdentifier();
        Event eventToSave = new Event(
                event.id(),
                event.name(),
                event.description(),
                identifier,
                event.startDate(),
                event.endDate(),
                event.address(),
                event.organizer(),
                event.capacity(),
                event.eventType()
        );

        if(repository.findByIdentifier(identifier).isPresent()){
            throw new UniqueConstraintViolationException("Esse identificador de evento já existe");
        }

        EventEntity eventEntity = eventEntityMapper.toEntity(eventToSave);
        EventEntity savedEvent = repository.save(eventEntity);
        return eventEntityMapper.toDomain(savedEvent);
    }

    @Override
    public List<Event> findAllEvents() {
        List<EventEntity> events = repository.findAll();
        return events.stream()
                .map(eventEntityMapper::toDomain)
                .toList();
    }

    @Override
    public Event findByIdentifier(String identifier) {
        Optional<EventEntity> eventEntity = repository.findByIdentifier(identifier);
            return eventEntity
                    .map(eventEntityMapper::toDomain)
                    .orElseThrow(() -> new EventNotFoundException("Event Not Found!"));
    }

    @Override
    public Event findById(Long id) {
        Optional<EventEntity> eventEntity = repository.findById(id);
        return eventEntity
                .map(eventEntityMapper::toDomain)
                .orElseThrow(() -> new EventNotFoundException("Event Not Found!"));
    }

    @Override
    public void deleteById(Long id) {
        Event event = findById(id);
        repository.deleteById(id);
    }


    @Override
    public String createRandomIdentifier() {
        // Pega um número aleatório entre 0 e 999
        // Usa-se a classe ThreadLocalRandom ao invés da classe Random, pois ela é mais moderna e eficiente para trabalhar com Multithreading
        int randomNumber = ThreadLocalRandom.current().nextInt(1000);

        // Formata o número para que valores que não tem 3 dígitos, recebam 0 a esquerda até complementar 3 dígitos
        // % significa o começo da especificação
        // 0 indica que é pra preencher com 0
        // 3 especifica que o número mínimo de caracteres são 3 (nesse caso, é o número mínimo e máximo, porque eu pedi para gerar número até o 999 com o ThreadLocalRandom
        // e o D indica que é um decimal integer
        String formattedRandomNumber = String.format("%03d", randomNumber);

        String randomLetters = RandomStringUtils.randomAlphabetic(3)
                .toUpperCase();

        String createdIdentifier = randomLetters + formattedRandomNumber;

        return createdIdentifier;
    }
}
