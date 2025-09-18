package ru.practicum.yandex.user.service;

import org.springframework.data.domain.Pageable;
import ru.practicum.yandex.exception.ConflictException;
import ru.practicum.yandex.exception.NotFoundException;
import ru.practicum.yandex.user.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto addUser(UserDto newUserDto) throws ConflictException;

    UserDto getUserById(Long userId) throws NotFoundException;

    List<UserDto> getUsersByIdList(List<Long> ids, Pageable page);

    void deleteUser(Long userId);
}
