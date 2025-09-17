package ru.practicum.yandex.categories.service;

import ru.practicum.yandex.categories.dto.CategoryDto;
import ru.practicum.yandex.categories.dto.NewCategoryDto;
import ru.practicum.yandex.categories.model.Category;

import java.util.List;

public interface CategoriesService {
    CategoryDto addCategory(NewCategoryDto newCategoryDto);

    CategoryDto updateCategory(Long id, NewCategoryDto newCategoryDto);

    void deleteCategory(Long id);

    CategoryDto findBy(Long id);

    List<CategoryDto> findBy(int from, int size);

    Category getOrThrow(Long id);
}
