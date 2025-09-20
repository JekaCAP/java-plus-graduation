package practicum.event.service;

import practicum.event.dto.EventFullDto;
import practicum.event.dto.UpdateEventAdminRequest;
import practicum.exception.ConflictException;
import practicum.exception.NotFoundException;
import practicum.exception.ValidationException;
import practicum.exception.WrongDataException;

import java.time.LocalDateTime;
import java.util.List;

public interface AdminEventService {

    List<EventFullDto> getEvents(List<Long> users, List<String> states, List<Long> categories, LocalDateTime rangeStart, LocalDateTime rangeEnd, Integer from, Integer size) throws ValidationException;

    EventFullDto updateEvent(Long eventId, UpdateEventAdminRequest event) throws ConflictException, ValidationException, NotFoundException, WrongDataException;

}
