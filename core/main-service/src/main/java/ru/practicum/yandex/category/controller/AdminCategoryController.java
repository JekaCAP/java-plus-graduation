package ru.practicum.yandex.category.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.yandex.category.dto.CategoryDto;
import ru.practicum.yandex.category.service.CategoryService;
import ru.practicum.yandex.exception.ConflictException;
import ru.practicum.yandex.exception.NotFoundException;


@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/categories")
public class AdminCategoryController {

    private static final String CATEGORY_PATH = "/{category-id}";

    private final CategoryService categoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryDto addCategory(@Valid @RequestBody CategoryDto newCategory) throws ConflictException {
        return categoryService.addCategory(newCategory);
    }

    @PatchMapping(CATEGORY_PATH)
    public CategoryDto updateCategory(@PathVariable(name = "category-id") Long categoryId,
                                      @Valid @RequestBody CategoryDto categoryDto) throws ConflictException, NotFoundException {
        return categoryService.updateCategory(categoryId, categoryDto);
    }

    @DeleteMapping(CATEGORY_PATH)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable(name = "category-id") Long categoryId) throws ConflictException, NotFoundException {
        categoryService.deleteCategory(categoryId);
    }
}
