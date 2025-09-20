package practicum.request.service;

import practicum.exception.ConflictException;
import practicum.exception.NotFoundException;
import practicum.exception.ValidationException;
import practicum.request.dto.EventRequestDto;

import java.util.List;

public interface EventRequestService {

    EventRequestDto addRequest(Long userId, Long eventId) throws ConflictException, NotFoundException;

    List<EventRequestDto> getUserRequests(Long userId) throws NotFoundException;

    List<EventRequestDto> getRequestsByEventId(Long userId, Long eventId) throws ValidationException, NotFoundException;

    EventRequestDto updateRequest(Long userId,
                                  Long eventId,
                                  EventRequestDto request) throws ConflictException, ValidationException, NotFoundException;

    EventRequestDto cancelRequest(Long userId, Long requestId) throws NotFoundException, ValidationException;
}
