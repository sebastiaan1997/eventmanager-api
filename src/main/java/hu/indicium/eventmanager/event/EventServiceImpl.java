package hu.indicium.eventmanager.event;


import hu.indicium.eventmanager.event.dto.EventDTO;
import hu.indicium.eventmanager.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    private final Validator<Event> eventValidator;

    public EventServiceImpl(EventRepository eventRepository, Validator<Event> eventValidator) {
        this.eventRepository = eventRepository;
        this.eventValidator = eventValidator;
    }

    @Override
    public List<EventDTO> getAllEvents() {
        return eventRepository.findAll()
            .stream()
            .map(EventMapper::map)
            .collect(Collectors.toList());
    }

    @Override
    public EventDTO addEvent(EventDTO eventDTO) {
        Event event = EventMapper.map(eventDTO);
        event.setId(null);
        event = validateAndSave(event);
        return EventMapper.map(event);
    }

    @Override
    public EventDTO updateEvent(EventDTO eventDTO) {
        getEventById(eventDTO.getId());
        Event event = EventMapper.map(eventDTO);
        event = validateAndSave(event);
        return EventMapper.map(event);
    }

    @Override
    public void deleteEventById(long eventId) {
        Event event = getEventById(eventId);
        eventRepository.delete(event);
    }

    @Override
    public EventDTO findEventById(Long eventId) {
        Event event = getEventById(eventId);
        return EventMapper.map(event);
    }

    private Event getEventById(Long eventId) {
        return this.eventRepository.findById(eventId)
            .orElseThrow(() -> new EntityNotFoundException(String.format("Evenement %d niet gevonden.", eventId)));
    }

    private Event validateAndSave(Event event) {
        this.eventValidator.validate(event);
        return this.eventRepository.save(event);
    }
}
