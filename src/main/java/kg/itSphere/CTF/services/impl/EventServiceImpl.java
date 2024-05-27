package kg.itSphere.CTF.services.impl;

import kg.itSphere.CTF.entities.Event;
import kg.itSphere.CTF.repository.EventRepository;
import kg.itSphere.CTF.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
}
