package hu.indicium.eventmanager.event;

import hu.indicium.eventmanager.event.dto.EventDTO;
import hu.indicium.eventmanager.event.request.CreateEventRequest;

import java.util.List;

public interface EventService {
    List<EventDTO> getAllEvents();

    EventDTO addEvent(EventDTO eventDTO);

    EventDTO updateEvent(EventDTO eventDTO);

    void deleteEventById(long eventId);

    EventDTO findEventById(Long eventId);
}
