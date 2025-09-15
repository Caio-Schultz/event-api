package dev.caioschultz.EventClean.infra.mapper;
import dev.caioschultz.EventClean.core.entities.Event;
import dev.caioschultz.EventClean.infra.dtos.EventDto;
import org.springframework.stereotype.Component;

@Component
public class EventMapper {

    public EventDto toDto(Event event){

        return new EventDto(event.id(),
                event.name(),
                event.description(),
                event.identifier(),
                event.startDate(),
                event.endDate(),
                event.address(),
                event.organizer(),
                event.capacity(),
                event.eventType());

    }

    public Event toEntity(EventDto dto){

         return new Event(dto.id(),
                dto.name(),
                dto.description(),
                dto.identifier(),
                dto.startDate(),
                dto.endDate(),
                dto.address(),
                dto.organizer(),
                dto.capacity(),
                dto.eventType());

    }



}
