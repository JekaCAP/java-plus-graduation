package ru.practicum.yandex.event.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import ru.practicum.yandex.category.dto.CategoryDto;
import ru.practicum.yandex.user.dto.UserDto;
import ru.practicum.yandex.util.JsonFormatPattern;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EventShortDto {

    Long id;
    String title;
    String annotation;

    Long confirmedRequests;
    CategoryDto category;
    UserDto initiator;

    @NotNull
    @JsonFormat(pattern = JsonFormatPattern.TIME_PATTERN)
    LocalDateTime eventDate;

    Boolean paid;
    Integer views;
}
