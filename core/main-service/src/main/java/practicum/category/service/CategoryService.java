package practicum.category.service;

import practicum.category.dto.CategoryDto;
import practicum.exception.ConflictException;
import practicum.exception.NotFoundException;

import java.util.List;

public interface CategoryService {
    CategoryDto addCategory(CategoryDto categoryDto) throws ConflictException;

    CategoryDto updateCategory(Long catId, CategoryDto categoryDto) throws NotFoundException, ConflictException;

    CategoryDto getCategoryById(Long catId) throws NotFoundException;

    List<CategoryDto> getAllCategories(Integer from, Integer size);

    void deleteCategory(Long catId) throws ConflictException, NotFoundException;
}
