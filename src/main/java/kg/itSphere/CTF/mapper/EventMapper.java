package kg.itSphere.CTF.mapper;

import kg.itSphere.CTF.dto.event.EventRequest;
import kg.itSphere.CTF.entities.Event;

public interface EventMapper {
    Event toDtoEvent(Event event, EventRequest eventRequest);
}
