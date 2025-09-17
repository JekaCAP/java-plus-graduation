package ru.practicum.yandex.request.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.practicum.yandex.request.dto.RequestDto;
import ru.practicum.yandex.request.model.Request;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RequestMapper {

    @Mapping(target = "event", source = "event.id")
    @Mapping(target = "requester", source = "requester.id")
    RequestDto toDto(Request request);

    List<RequestDto> toDtos(List<Request> requests);

    @Mapping(target = "event.id", source = "event")
    @Mapping(target = "requester.id", source = "requester")
    Request toEntity(RequestDto requestDto);

    List<Request> toEntities(List<RequestDto> requestDtos);
}
