package hu.indicium.eventmanager.event;

import hu.indicium.eventmanager.event.dto.EventDTO;
import org.modelmapper.ModelMapper;

public class EventMapper {
    public static Event map(EventDTO eventDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(eventDTO, Event.class);
    }

    public static EventDTO map(Event event) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(event, EventDTO.class);
    }
}
