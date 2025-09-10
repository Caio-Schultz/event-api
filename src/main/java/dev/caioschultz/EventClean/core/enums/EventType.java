package dev.caioschultz.EventClean.core.enums;

public enum EventType {

    NETWORKING("Evento de networking"),
    HACKATHON("Hackathon"),
    AWARD_CEREMONY("Cerimônia de premiação"),
    MUSIC("Evento de música"),
    CONFERENCE("Conferência"),
    SEMINAR("Seminário"),
    WORKSHOP("Worshop"),
    WEBINAR("Webinar"),
    MEETUP("Encontro");

    private String eventType;

    EventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
}
