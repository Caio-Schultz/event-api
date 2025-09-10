package dev.caioschultz.EventClean.core.entities;

import dev.caioschultz.EventClean.core.enums.EventType;

import java.time.LocalDateTime;

public record Event(Long id,
                    String name,
                    String description,
                    String identifier,
                    LocalDateTime startDate,
                    LocalDateTime endDate,
                    String address,
                    String organizer,
                    Integer capacity,
                    EventType eventType) {
}
