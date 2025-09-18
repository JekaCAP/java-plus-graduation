package ru.practicum.yandex.compilation.service;

import ru.practicum.yandex.compilation.dto.NewCompilationDto;
import ru.practicum.yandex.compilation.dto.ResponseCompilationDto;
import ru.practicum.yandex.compilation.dto.UpdateCompilationRequest;
import ru.practicum.yandex.exception.NotFoundException;
import ru.practicum.yandex.exception.ValidationException;

import java.util.List;

public interface CompilationService {
    ResponseCompilationDto addCompilation(NewCompilationDto dto);

    ResponseCompilationDto updateCompilation(Long compId, UpdateCompilationRequest compilation) throws NotFoundException;

    ResponseCompilationDto getCompilationById(Long id) throws NotFoundException;

    List<ResponseCompilationDto> getCompilations(Boolean pinned, Integer from, Integer size);

    void deleteCompilation(Long id) throws ValidationException, NotFoundException;
}
