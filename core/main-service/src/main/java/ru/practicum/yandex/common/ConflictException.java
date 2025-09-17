package ru.practicum.yandex.common;

public class ConflictException extends RuntimeException {
    public ConflictException(final String message) {
        super(message);
    }
}
