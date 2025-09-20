package practicum.event.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import ru.practicum.client.util.JsonFormatPattern;
import practicum.event.dto.EventFullDto;
import practicum.event.dto.UpdateEventAdminRequest;
import practicum.event.service.AdminEventService;
import practicum.exception.ConflictException;
import practicum.exception.NotFoundException;
import practicum.exception.ValidationException;
import practicum.exception.WrongDataException;

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
