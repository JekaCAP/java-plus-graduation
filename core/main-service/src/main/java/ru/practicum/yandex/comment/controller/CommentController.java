package ru.practicum.yandex.comment.controller;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.yandex.comment.dto.CommentDto;
import ru.practicum.yandex.comment.service.CommentService;
import ru.practicum.yandex.exception.NotFoundException;

import java.util.Collection;

@RequiredArgsConstructor
@RestController
@RequestMapping("/events/{event-id}/comments")
public class CommentController {

    private final CommentService service;

    @GetMapping
    public Collection<CommentDto> getByEvent(
            @PathVariable(name = "event-id") Long eventId,
            @RequestParam(defaultValue = "0") @PositiveOrZero Integer from,
            @RequestParam(defaultValue = "10") @Positive Integer size) throws NotFoundException {
        return service.getAllEventComments(eventId, from, size);
    }
}

