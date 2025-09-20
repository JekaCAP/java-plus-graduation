package practicum.event.service;

import practicum.event.dto.EventFullDto;
import practicum.event.dto.EventShortDto;
import practicum.exception.NotFoundException;
import practicum.exception.ValidationException;

import java.util.List;

public interface EventService {
    EventFullDto getEventById(Long eventId, String uri, String ip) throws NotFoundException;

    List<EventShortDto> getFilteredEvents(String text,
                                          List<Long> categories,
                                          Boolean paid,
                                          String rangeStart,
                                          String rangeEnd,
                                          Boolean onlyAvailable,
                                          String sort,
                                          Integer from,
                                          Integer size,
                                          String uri,
                                          String ip) throws ValidationException;
}
