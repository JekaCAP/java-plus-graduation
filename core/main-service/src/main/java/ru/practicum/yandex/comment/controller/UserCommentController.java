package ru.practicum.yandex.comment.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.yandex.comment.dto.CommentDto;
import ru.practicum.yandex.comment.service.CommentService;
import ru.practicum.yandex.exception.ConflictException;
import ru.practicum.yandex.exception.NotFoundException;

import java.util.Collection;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/users/{user-id}/comments")
public class UserCommentController {

    private final static String COMMENT_PATH = "/{comment-id}";

    private final CommentService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentDto addComments(
            @PathVariable(name = "user-id") Long userId,
            @RequestParam @Positive Long eventId,
            @RequestBody @Validated CommentDto commentDto) throws ConflictException, NotFoundException {
        return service.addComment(commentDto, userId, eventId);
    }

    @DeleteMapping(COMMENT_PATH)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComment(
            @PathVariable(name = "comment-id") @NonNull Long commentId,
            @PathVariable(name = "user-id") @NonNull Long userId) throws ConflictException, NotFoundException {
        service.delete(userId, commentId);
    }

    @PatchMapping(COMMENT_PATH)
    public CommentDto updateComment(
            @PathVariable(name = "user-id") Long userId,
            @PathVariable(name = "comment-id") Long commentId,
            @RequestBody @Valid CommentDto commentDto) throws ConflictException, NotFoundException {
        return service.updateUserComment(userId, commentId, commentDto);
    }

    @GetMapping
    public Collection<CommentDto> getByUserComment(@PathVariable(name = "user-id") Long userId) throws NotFoundException {
        return service.getAllUserComments(userId);
    }
}