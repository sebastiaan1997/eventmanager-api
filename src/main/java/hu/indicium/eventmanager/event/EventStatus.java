package hu.indicium.eventmanager.event;

public enum EventStatus {
    DRAFT(0),
    SCHEDULED(1),
    PUBLISHED(2),
    PRIVATE(2);

    public final int statusCode;

    EventStatus(int statusCode) {
        this.statusCode = statusCode;
    }
}
