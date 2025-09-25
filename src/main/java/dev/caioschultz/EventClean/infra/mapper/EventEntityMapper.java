package dev.caioschultz.EventClean.infra.mapper;

import dev.caioschultz.EventClean.core.entities.Event;
import dev.caioschultz.EventClean.infra.persistence.EventEntity;
import org.springframework.stereotype.Component;

@Component
public class EventEntityMapper {

    public EventEntity toEntity(Event event){

        return new EventEntity(event.id(),
                              event.name(),
                              event.description(),
                              event.identifier(),
                              event.startDate(),
                              event.endDate(),
                              event.address(),
                              event.organizer(),
                              event.capacity(),
                              event.eventType()
        );
    }

    public Event toDomain(EventEntity eventEntity){

        return new Event(eventEntity.getId(),
                         eventEntity.getName(),
                         eventEntity.getDescription(),
                         eventEntity.getIdentifier(),
                         eventEntity.getStartDate(),
                         eventEntity.getEndDate(),
                         eventEntity.getAddress(),
                         eventEntity.getOrganizer(),
                         eventEntity.getCapacity(),
                         eventEntity.getEventType()
        );
    }



}
