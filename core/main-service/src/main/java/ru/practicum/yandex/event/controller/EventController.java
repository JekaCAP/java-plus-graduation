package ru.practicum.yandex.event.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.yandex.event.dto.EventFullDto;
import ru.practicum.yandex.event.dto.EventShortDto;
import ru.practicum.yandex.event.service.EventService;
import ru.practicum.yandex.exception.NotFoundException;
import ru.practicum.yandex.exception.ValidationException;

import java.util.List;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EventController {

    final EventService eventService;

    @GetMapping("/{id}")
    public EventFullDto getEventById(@PathVariable Long id,
                                     HttpServletRequest request) throws NotFoundException {
        return eventService.getEventById(id, request.getRequestURI(), request.getRemoteAddr());
    }

    @GetMapping
    public List<EventShortDto> getFilteredEvents(@RequestParam(required = false) String text,
                                                 @RequestParam(required = false) List<Long> categories,
                                                 @RequestParam(required = false) Boolean paid,
                                                 @RequestParam(required = false) String rangeStart,
                                                 @RequestParam(required = false) String rangeEnd,
                                                 @RequestParam(defaultValue = "false") Boolean available,
                                                 @RequestParam(defaultValue = "EVENT_DATE") String sort,
                                                 @PositiveOrZero @RequestParam(defaultValue = "0") Integer from,
                                                 @Positive @RequestParam(defaultValue = "10") Integer count,
                                                 HttpServletRequest request) throws ValidationException {
        return eventService.getFilteredEvents(text, categories, paid, rangeStart, rangeEnd, available, sort, from, count,
                request.getRequestURI(), request.getRemoteAddr());
    }
}