package ru.practicum.yandex.event.service;

import ru.practicum.yandex.event.dto.EventFullDto;
import ru.practicum.yandex.event.dto.EventShortDto;
import ru.practicum.yandex.exception.NotFoundException;
import ru.practicum.yandex.exception.ValidationException;

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
