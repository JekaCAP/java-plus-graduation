package ru.practicum.yandex.compilation.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.yandex.compilation.dto.ResponseCompilationDto;
import ru.practicum.yandex.compilation.service.CompilationService;
import ru.practicum.yandex.exception.NotFoundException;

import java.util.List;

@RestController
@RequestMapping("/compilations")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PublicCompilationController {

    final CompilationService compilationService;

    @GetMapping
    public List<ResponseCompilationDto> getAll(@RequestParam(required = false) Boolean pinned,
                                               @RequestParam(defaultValue = "0") Integer from,
                                               @RequestParam(defaultValue = "10") Integer size) {
        return compilationService.getCompilations(pinned, from, size);
    }

    @GetMapping("/{compilation-id}")
    public ResponseCompilationDto getCompilationById(@PathVariable(name = "compilation-id") Long compilationId) throws NotFoundException {
        return compilationService.getCompilationById(compilationId);
    }


}
