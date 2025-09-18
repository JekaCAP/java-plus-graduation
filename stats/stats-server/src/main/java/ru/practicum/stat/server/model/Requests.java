package ru.practicum.stat.server.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static ru.practicum.stat.server.util.JsonFormatPattern.JSON_FORMAT_PATTERN_FOR_TIME;

@Entity
@Table(name = "hits")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Requests {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String application;

    @NotNull
    @Column(nullable = false)
    String uri;

    @Column(nullable = false)
    String ip;

    @DateTimeFormat(pattern = JSON_FORMAT_PATTERN_FOR_TIME)
    @Column(nullable = false)
    LocalDateTime moment;
}
