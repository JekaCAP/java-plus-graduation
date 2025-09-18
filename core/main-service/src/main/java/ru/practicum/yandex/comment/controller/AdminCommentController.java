package ru.practicum.yandex.comment.controller;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.yandex.comment.dto.CommentDto;
import ru.practicum.yandex.comment.dto.GetCommentsAdminRequest;
import ru.practicum.yandex.comment.service.CommentService;
import ru.practicum.yandex.exception.NotFoundException;

import java.util.Collection;

@RestController
@RequestMapping("/admin/comments")
@RequiredArgsConstructor
@Validated
public class AdminCommentController {

    private final CommentService service;

    @GetMapping
    public Collection<CommentDto> getComments(
            @RequestParam("eventId") @Positive Long eventId,
            @RequestParam(defaultValue = "0") @PositiveOrZero Integer from,
            @RequestParam(defaultValue = "10") @Positive Integer size) throws NotFoundException {
        return service.getAllEventComments(new GetCommentsAdminRequest(eventId, from, size));
    }

    @DeleteMapping("/{comment-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeComment(@PathVariable("comment-id") Long commentId) throws NotFoundException {
        service.delete(commentId);
    }
}