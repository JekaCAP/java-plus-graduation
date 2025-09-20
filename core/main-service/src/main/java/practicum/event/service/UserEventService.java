package practicum.event.service;

import practicum.event.dto.EventFullDto;
import practicum.event.dto.EventShortDto;
import practicum.event.dto.NewEventDto;
import practicum.event.dto.UpdateEventUserRequest;
import practicum.exception.ConflictException;
import practicum.exception.NotFoundException;
import practicum.exception.ValidationException;
import practicum.exception.WrongDataException;

import java.util.List;

public interface UserEventService {

    EventFullDto addEvent(Long userId, NewEventDto event) throws ValidationException, WrongDataException, NotFoundException;

    EventFullDto updateEvent(Long userId, Long eventId, UpdateEventUserRequest event) throws ConflictException, NotFoundException, ValidationException, WrongDataException;

    List<EventShortDto> getUserEvents(Long userId, Integer from, Integer count) throws NotFoundException;

    EventFullDto getEventById(Long userId, Long eventId) throws NotFoundException, ValidationException;
}
