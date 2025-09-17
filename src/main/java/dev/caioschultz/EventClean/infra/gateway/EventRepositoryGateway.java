package dev.caioschultz.EventClean.infra.gateway;

import dev.caioschultz.EventClean.core.entities.Event;
import dev.caioschultz.EventClean.core.gateway.EventGateway;
import dev.caioschultz.EventClean.infra.exceptions.UniqueConstraintViolationException;
import dev.caioschultz.EventClean.infra.mapper.EventEntityMapper;
import dev.caioschultz.EventClean.infra.persistence.EventEntity;
import dev.caioschultz.EventClean.infra.persistence.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
public class EventRepositoryGateway implements EventGateway {

    private final EventRepository repository;
    private final EventEntityMapper eventEntityMapper;

    @Override
    public Event createEvent(Event event) {
        try {
            EventEntity eventEntity = eventEntityMapper.toEntity(event);
            EventEntity savedEvent = repository.save(eventEntity);
            return eventEntityMapper.toDomain(savedEvent);
        }
        catch (Exception exception){
            throw new UniqueConstraintViolationException("Identificador do evento já existe");
        }
    }

    @Override
    public List<Event> findAllEvents() {
        List<EventEntity> events = repository.findAll();
        return events.stream()
                .map(eventEntityMapper::toDomain)
                .toList();
    }


}
