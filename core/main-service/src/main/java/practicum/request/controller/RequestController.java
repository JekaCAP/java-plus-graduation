package practicum.request.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import practicum.exception.ConflictException;
import practicum.exception.NotFoundException;
import practicum.exception.ValidationException;
import practicum.request.dto.EventRequestDto;
import practicum.request.service.EventRequestService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users/{user-id}")
public class RequestController {

    final EventRequestService requestService;

    @PostMapping("/requests")
    @ResponseStatus(HttpStatus.CREATED)
    public EventRequestDto addEventRequest(@PathVariable(name = "user-id") Long userId,
                                           @RequestParam Long eventId) throws ConflictException, NotFoundException {
        return requestService.addRequest(userId, eventId);
    }

    @GetMapping("/requests")
    public List<EventRequestDto> getUserRequests(@PathVariable(name = "user-id") Long userId) throws NotFoundException {
        return requestService.getUserRequests(userId);
    }

    @GetMapping("/events/{event-id}/requests")
    public List<EventRequestDto> getRequestsByEventId(@PathVariable(name = "user-id") Long userId,
                                                      @PathVariable(name = "event-id") Long eventId) throws ValidationException, NotFoundException {
        return requestService.getRequestsByEventId(userId, eventId);
    }

    @PatchMapping("/events/{event-id}/requests")
    public EventRequestDto updateRequest(@PathVariable(name = "user-id") Long userId,
                                         @PathVariable(name = "event-id") Long eventId,
                                         @RequestBody EventRequestDto request) throws ValidationException, ConflictException, NotFoundException {
        return requestService.updateRequest(userId, eventId, request);
    }

    @PatchMapping("/requests/{request-id}/cancel")
    public EventRequestDto cancelRequest(@PathVariable(name = "user-id") Long userId,
                                         @PathVariable(name = "request-id") Long requestId) throws ValidationException, NotFoundException {
        return requestService.cancelRequest(userId, requestId);
    }
}
