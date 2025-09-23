package ru.practicum.application.comment.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import ru.practicum.util.JsonFormatPattern;

import java.time.LocalDateTime;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comment")
@EqualsAndHashCode(of = "id")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "user_id", nullable = false)
    Long user;

    @Column(name = "event_id", nullable = false)
    Long event;

    @Column(nullable = false, length = 5000)
    String content;

    @Column(name = "is_initiator", nullable = false)
    boolean isInitiator;

    @Column(name = "created", nullable = false)
    @JsonFormat(pattern = JsonFormatPattern.TIME_PATTERN)
    LocalDateTime created;
}
