package hu.indicium.eventmanager.event;

import hu.indicium.eventmanager.event.dto.EventDTO;
import hu.indicium.eventmanager.event.request.CreateEventRequest;
import hu.indicium.eventmanager.util.Response;
import hu.indicium.eventmanager.util.ResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static hu.indicium.eventmanager.util.BaseUrl.API_V1;

@RestController
@RequestMapping(API_V1 + "/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Response<List<EventDTO>> getEvents() {
        List<EventDTO> eventDTOS = eventService.getAllEvents();
        return ResponseBuilder.ok()
            .data(eventDTOS)
            .build();
    }

    @GetMapping(value = "/{eventId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Response<EventDTO> getEvent(@PathVariable Long eventId) {
        EventDTO event = eventService.findEventById(eventId);
        return ResponseBuilder.ok()
            .data(event)
            .build();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Response<EventDTO> createEvent(@RequestBody @Valid CreateEventRequest createEventRequest) {
        EventDTO eventDTO = map(createEventRequest);
        eventDTO = eventService.addEvent(eventDTO);
        return ResponseBuilder.created()
            .data(eventDTO)
            .build();
    }

    @PutMapping(value = "/{eventId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Response<EventDTO> updateEvent(@RequestBody @Valid CreateEventRequest createEventRequest, @PathVariable Long eventId) {
        EventDTO eventDTO = map(createEventRequest);
        eventDTO.setId(eventId);
        eventDTO = eventService.updateEvent(eventDTO);
        return ResponseBuilder.accepted()
            .data(eventDTO)
            .build();
    }

    @DeleteMapping(value = "/{eventId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Response<?> deleteEvent(@PathVariable Long eventId) {
        eventService.deleteEventById(eventId);
        return ResponseBuilder.ok()
            .build();
    }

    private EventDTO map(CreateEventRequest createEventRequest) {
        EventDTO eventDTO = new EventDTO();
        eventDTO.setStartDate(createEventRequest.getStartDate());
        eventDTO.setEndDate(createEventRequest.getEndDate());
        eventDTO.setSlug(createEventRequest.getSlug());
        eventDTO.setStatus(createEventRequest.getStatus());
        eventDTO.setTitle(createEventRequest.getTitle());
        eventDTO.setDescription(createEventRequest.getDescription());
        eventDTO.setUrl(createEventRequest.getUrl());
        return eventDTO;
    }
}
