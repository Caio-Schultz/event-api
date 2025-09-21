package dev.caioschultz.EventClean.infra.gateway;

import dev.caioschultz.EventClean.core.entities.Event;
import dev.caioschultz.EventClean.core.gateway.EventGateway;
import dev.caioschultz.EventClean.infra.exceptions.EventNotFoundException;
import dev.caioschultz.EventClean.infra.exceptions.UniqueConstraintViolationException;
import dev.caioschultz.EventClean.infra.mapper.EventEntityMapper;
import dev.caioschultz.EventClean.infra.persistence.EventEntity;
import dev.caioschultz.EventClean.infra.persistence.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class EventRepositoryGateway implements EventGateway {

    private final EventRepository repository;
    private final EventEntityMapper eventEntityMapper;

    @Override
    public Event createEvent(Event event) {

        if(findByIdentifier(event.identifier()) != null){
            throw new UniqueConstraintViolationException("Esse identificador de evento já existe");
        }

        EventEntity eventEntity = eventEntityMapper.toEntity(event);
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
                    .orElse(null);
    }

    @Override
    public Event findById(Long id) {
        Optional<EventEntity> eventEntity = repository.findById(id);
        return eventEntity
                .map(eventEntityMapper::toDomain)
                .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        Event event = findById(id);
        if (event == null){
            throw new EventNotFoundException("Event Not Found!");
        }

        repository.deleteById(id);
    }


}
