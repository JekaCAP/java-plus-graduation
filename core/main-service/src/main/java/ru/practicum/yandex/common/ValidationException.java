package ru.practicum.yandex.common;

public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}
