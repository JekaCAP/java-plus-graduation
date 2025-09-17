package ru.practicum.yandex.compilation.service;

import java.util.List;

import org.apache.coyote.BadRequestException;
import ru.practicum.yandex.compilation.dto.CompilationDto;
import ru.practicum.yandex.compilation.dto.NewCompilationDto;
import ru.practicum.yandex.compilation.dto.UpdateCompilationRequest;

public interface CompilationService {
    List<CompilationDto> getAll(boolean pinned, int from, int size);

    CompilationDto get(Long id);

    CompilationDto addNewCompilation(NewCompilationDto newCompilationDto) throws BadRequestException;

    void delete(Long id);

    CompilationDto update(Long id, UpdateCompilationRequest request) throws BadRequestException;
}
