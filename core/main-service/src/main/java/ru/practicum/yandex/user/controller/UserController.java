package ru.practicum.yandex.user.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.yandex.exception.ConflictException;
import ru.practicum.yandex.user.dto.UserDto;
import ru.practicum.yandex.user.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDto> getUsersList(@RequestParam(required = false) List<Long> ids,
                                      @RequestParam(required = false, defaultValue = "0") Integer from,
                                      @RequestParam(required = false, defaultValue = "10") Integer size) {
        return userService.getUsersByIdList(ids, PageRequest.of(from, size));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto addUser(@Valid @RequestBody UserDto newUser) throws ConflictException {
        return userService.addUser(newUser);
    }

    @DeleteMapping("/{user-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable(name = "user-id") Long userId) {
        userService.deleteUser(userId);
    }
}