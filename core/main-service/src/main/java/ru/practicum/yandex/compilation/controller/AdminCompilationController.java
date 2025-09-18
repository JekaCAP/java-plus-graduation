package ru.practicum.yandex.compilation.controller;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.yandex.compilation.dto.NewCompilationDto;
import ru.practicum.yandex.compilation.dto.ResponseCompilationDto;
import ru.practicum.yandex.compilation.dto.UpdateCompilationRequest;
import ru.practicum.yandex.compilation.service.CompilationService;
import ru.practicum.yandex.exception.NotFoundException;
import ru.practicum.yandex.exception.ValidationException;

@RestController
@RequestMapping("/admin/compilations")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AdminCompilationController {

    private final static String COMPILATION_PATH = "/{compilation-id}";

    final CompilationService compilationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseCompilationDto add(@Valid @RequestBody NewCompilationDto compilationDto) {
        return compilationService.addCompilation(compilationDto);
    }

    @PatchMapping(COMPILATION_PATH)
    public ResponseCompilationDto update(@PathVariable(name = "compilation-id") Long compId,
                                         @Valid @RequestBody UpdateCompilationRequest compilationDto) throws NotFoundException {
        return compilationService.updateCompilation(compId, compilationDto);
    }

    @DeleteMapping(COMPILATION_PATH)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(name = "compilation-id") Long compId) throws ValidationException, NotFoundException {
        compilationService.deleteCompilation(compId);
    }
}
