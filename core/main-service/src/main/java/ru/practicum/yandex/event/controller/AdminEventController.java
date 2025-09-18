package ru.practicum.yandex.event.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.client.util.JsonFormatPattern;
import ru.practicum.yandex.event.dto.EventFullDto;
import ru.practicum.yandex.event.dto.UpdateEventAdminRequest;
import ru.practicum.yandex.event.service.AdminEventService;
import ru.practicum.yandex.exception.ConflictException;
import ru.practicum.yandex.exception.NotFoundException;
import ru.practicum.yandex.exception.ValidationException;
import ru.practicum.yandex.exception.WrongDataException;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/admin/events")
@RequiredArgsConstructor
public class AdminEventController {

    private final AdminEventService eventService;

    @GetMapping
    public List<EventFullDto> getEvents(@RequestParam(required = false) List<Long> users,
                                        @RequestParam(required = false) List<String> states,
                                        @RequestParam(required = false) List<Long> categories,
                                        @DateTimeFormat(pattern = JsonFormatPattern.TIME_PATTERN) @RequestParam(required = false) LocalDateTime rangeStart,
                                        @DateTimeFormat(pattern = JsonFormatPattern.TIME_PATTERN) @RequestParam(required = false) LocalDateTime rangeEnd,
                                        @RequestParam(defaultValue = "0") Integer from,
                                        @RequestParam(defaultValue = "10") Integer size) throws ValidationException {
        return eventService.getEvents(users, states, categories, rangeStart, rangeEnd, from, size);
    }

    @PatchMapping("/{event-id}")
    public EventFullDto updateEvent(@PathVariable(name = "event-id") Long eventId,
                                    @Valid @RequestBody UpdateEventAdminRequest event) throws ValidationException, ConflictException, WrongDataException, NotFoundException {
        return eventService.updateEvent(eventId, event);
    }
}
