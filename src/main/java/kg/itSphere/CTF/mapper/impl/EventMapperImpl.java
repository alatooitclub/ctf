package kg.itSphere.CTF.mapper.impl;

import kg.itSphere.CTF.dto.event.DateTimeRequest;
import kg.itSphere.CTF.dto.event.EventRequest;
import kg.itSphere.CTF.entities.Event;
import kg.itSphere.CTF.mapper.EventMapper;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
public class EventMapperImpl implements EventMapper {
    @Override
    public Event toDtoEvent(Event event, EventRequest eventRequest) {
        event.setName(eventRequest.getName());
        event.setDescription(eventRequest.getDescription());
        event.setLocation(eventRequest.getLocation());
        event.setFormat(eventRequest.getFormat());
        event.setStartDate(toDateTime(eventRequest.getDateStart()));
        event.setEndDate(toDateTime(eventRequest.getDateEnd()));
        return event;
    }

    private LocalDateTime toDateTime(DateTimeRequest date) {
        int year = date.getYear();
        int month = date.getMonth();
        int day = date.getDay();
        int hour = date.getHour() != null ? date.getHour() : 0;
        int minutes = date.getMinute() != null ? date.getMinute() : 0;
        int seconds = date.getSeconds() != null ? date.getSeconds() : 0;
        return LocalDateTime.of(year, month, day, hour, minutes, seconds);
    }
}
