package ru.practicum.yandex.category.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.yandex.category.dto.CategoryDto;
import ru.practicum.yandex.category.service.CategoryService;
import ru.practicum.yandex.exception.NotFoundException;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class PublicCategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryDto> getAllCategories(@RequestParam(defaultValue = "0") Integer from,
                                              @RequestParam(defaultValue = "10") Integer size) {
        return categoryService.getAllCategories(from, size);
    }

    @GetMapping("/{category-id}")
    public CategoryDto getCategoryById(@PathVariable(name = "category-id") Long categoryId) throws NotFoundException {
        return categoryService.getCategoryById(categoryId);
    }
}
