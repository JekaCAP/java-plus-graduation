package ru.practicum.yandex.event.controller;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.yandex.event.dto.EventFullDto;
import ru.practicum.yandex.event.dto.EventShortDto;
import ru.practicum.yandex.event.dto.NewEventDto;
import ru.practicum.yandex.event.dto.UpdateEventUserRequest;
import ru.practicum.yandex.event.service.UserEventService;
import ru.practicum.yandex.exception.ConflictException;
import ru.practicum.yandex.exception.NotFoundException;
import ru.practicum.yandex.exception.ValidationException;
import ru.practicum.yandex.exception.WrongDataException;

import java.util.List;

@RestController
@RequestMapping("/users/{user-id}/events")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEventController {

    final UserEventService eventService;

    @GetMapping
    public List<EventShortDto> getUserEvents(@PathVariable(name = "user-id") Long userId,
                                             @RequestParam(defaultValue = "0") Integer from,
                                             @RequestParam(defaultValue = "10") Integer count) throws NotFoundException {
        return eventService.getUserEvents(userId, from, count);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EventFullDto addEvent(@PathVariable(name = "user-id") Long userId,
                                 @Valid @RequestBody NewEventDto event) throws ValidationException, WrongDataException, NotFoundException {
        return eventService.addEvent(userId, event);
    }

    @GetMapping("/{event-id}")
    public EventFullDto getEventById(@PathVariable(name = "user-id") Long userId,
                                     @PathVariable(name = "event-id") Long eventId) throws ValidationException, NotFoundException {
        return eventService.getEventById(userId, eventId);
    }

    @PatchMapping("/{event-id}")
    public EventFullDto updateEvent(@PathVariable(name = "user-id") Long userId,
                                    @PathVariable(name = "event-id") Long eventId,
                                    @Valid @RequestBody UpdateEventUserRequest event) throws ValidationException, ConflictException, WrongDataException, NotFoundException {
        return eventService.updateEvent(userId, eventId, event);
    }
}
