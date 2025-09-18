package ru.practicum.yandex.event.service;

import ru.practicum.yandex.event.dto.EventFullDto;
import ru.practicum.yandex.event.dto.EventShortDto;
import ru.practicum.yandex.event.dto.NewEventDto;
import ru.practicum.yandex.event.dto.UpdateEventUserRequest;
import ru.practicum.yandex.exception.ConflictException;
import ru.practicum.yandex.exception.NotFoundException;
import ru.practicum.yandex.exception.ValidationException;
import ru.practicum.yandex.exception.WrongDataException;

import java.util.List;

public interface UserEventService {

    EventFullDto addEvent(Long userId, NewEventDto event) throws ValidationException, WrongDataException, NotFoundException;

    EventFullDto updateEvent(Long userId, Long eventId, UpdateEventUserRequest event) throws ConflictException, NotFoundException, ValidationException, WrongDataException;

    List<EventShortDto> getUserEvents(Long userId, Integer from, Integer count) throws NotFoundException;

    EventFullDto getEventById(Long userId, Long eventId) throws NotFoundException, ValidationException;
}
