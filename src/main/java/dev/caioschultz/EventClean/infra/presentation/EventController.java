package dev.caioschultz.EventClean.infra.presentation;
import dev.caioschultz.EventClean.core.entities.Event;
import dev.caioschultz.EventClean.core.usecases.create.CreateEventUseCase;
import dev.caioschultz.EventClean.core.usecases.findall.FindAllEventUseCase;
import dev.caioschultz.EventClean.core.usecases.findbyidentifier.FindEventByIdentifierUseCase;
import dev.caioschultz.EventClean.infra.dtos.EventDto;
import dev.caioschultz.EventClean.infra.mapper.EventDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/eventclean")
@RequiredArgsConstructor
public class EventController {

    private final CreateEventUseCase createEventCase;
    private final EventDtoMapper eventMapper;
    private final FindAllEventUseCase findAllEventCase;
    private final FindEventByIdentifierUseCase findByIdentifierCase;


    // Retornando com Map o ResponseEntity é possível retornar uma mensagem + um objeto (no caso, o EventoDto criado)
    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createEvent(@RequestBody EventDto request){

        Event newEvent = createEventCase.execute(eventMapper.toDomain(request));
        EventDto createdEvent = eventMapper.toDto(newEvent);

        Map<String, Object> response = new HashMap<>();
        response.put("Mensagem: " , "Evento salvo com succeso!");
        response.put("Dados do evento: " , createdEvent);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<EventDto>> findAllEvents(){

        List<Event> events = findAllEventCase.execute();

        return ResponseEntity.ok(events.stream()
                .map(eventMapper::toDto)
                .toList());
    }

    @GetMapping("/{identifier}")
    public ResponseEntity<Map<String, Object>> findByIdentifier(@PathVariable String identifier){
        Event event = findByIdentifierCase.execute(identifier);
        Map<String, Object> response = new HashMap<>();

        if(event == null){
            response.put("Mensagem: ", "Evento não encontrado pelo identificador!");
            response.put("Sugestão: ", "Verifique se o identificador do evento é válido!");

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        EventDto eventFound = eventMapper.toDto(event);

        response.put("Mensagem: ", "Evento encontrado pelo identificador!");
        response.put("Dados do evento: ", eventFound);

        return ResponseEntity.ok(response);


    }

}
