package ru.practicum.yandex.event.dto;

import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import ru.practicum.yandex.category.dto.CategoryDto;
import ru.practicum.yandex.event.model.EventState;
import ru.practicum.yandex.event.model.Location;
import ru.practicum.yandex.user.dto.UserDto;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EventFullDto {

    Long id;

    @Size(min = 1, max = 128)
    String title;

    @Size(min = 1, max = 1024)
    String annotation;

    CategoryDto category;

    Boolean paid;

    String eventDate;

    UserDto initiator;

    @Size(min = 1, max = 1024)
    String description;

    Integer participantLimit;

    EventState state;

    String createdOn;

    Location location;

    Boolean requestModeration;

    Long confirmedRequests;

    String publishedOn;

    Integer views;
}
