package ru.practicum.yandex.user.service;

import ru.practicum.yandex.user.dto.UserDto;
import ru.practicum.yandex.user.dto.UserRequestDto;
import ru.practicum.yandex.user.model.User;

import java.util.List;

public interface UserService {
    UserDto getUser(Long userId);

    List<UserDto> getUsers(List<Long> ids, Integer from, Integer size);

    UserDto registerUser(UserRequestDto userRequestDto);

    void delete(Long userId);

    User getOrThrow(Long id);
}
