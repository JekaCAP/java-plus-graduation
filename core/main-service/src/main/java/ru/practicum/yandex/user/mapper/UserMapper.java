package ru.practicum.yandex.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.practicum.yandex.user.dto.UserDto;
import ru.practicum.yandex.user.dto.UserRequestDto;
import ru.practicum.yandex.user.dto.UserShortDto;
import ru.practicum.yandex.user.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    User toEntity(UserRequestDto dto);

    UserDto toDto(User entity);

    User toEntity(UserDto dto);

    UserShortDto toShortDto(User entity);
}
