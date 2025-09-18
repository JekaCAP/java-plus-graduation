package ru.practicum.yandex.category.dto;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import ru.practicum.yandex.category.model.Category;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class CategoryMapper {

    public static Category mapCategoryDto(CategoryDto categoryDto) {
        return new Category(null, categoryDto.getName());
    }

    public static CategoryDto mapCategory(Category category) {
        return new CategoryDto(category.getId(), category.getName());
    }
}
