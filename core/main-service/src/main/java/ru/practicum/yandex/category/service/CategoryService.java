package ru.practicum.yandex.category.service;


import ru.practicum.yandex.category.dto.CategoryDto;
import ru.practicum.yandex.exception.ConflictException;
import ru.practicum.yandex.exception.NotFoundException;

import java.util.List;

public interface CategoryService {
    CategoryDto addCategory(CategoryDto categoryDto) throws ConflictException;

    CategoryDto updateCategory(Long catId, CategoryDto categoryDto) throws NotFoundException, ConflictException;

    CategoryDto getCategoryById(Long catId) throws NotFoundException;

    List<CategoryDto> getAllCategories(Integer from, Integer size);

    void deleteCategory(Long catId) throws ConflictException, NotFoundException;
}
