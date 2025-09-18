package ru.practicum.yandex.event.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import ru.practicum.yandex.category.model.Category;
import ru.practicum.yandex.compilation.model.Compilation;
import ru.practicum.yandex.user.model.User;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "events")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, length = 1024)
    String annotation;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    Category category;

    @Column(name = "created_on")
    LocalDateTime createdOn;

    @Column(length = 1024)
    String description;

    @Column(nullable = false, name = "event_date")
    LocalDateTime eventDate;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    User initiator;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    Location location;

    @Column
    Boolean paid;

    @Column(name = "participant_limit")
    Integer participantLimit;

    @Column(name = "published_on")
    LocalDateTime publishedOn;

    @Column(name = "request_moderation")
    Boolean requestModeration;

    @Enumerated(EnumType.STRING)
    EventState state;

    @Column(nullable = false)
    String title;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "events_compilations",
            joinColumns = @JoinColumn(name = "compilation"),
            inverseJoinColumns = @JoinColumn(name = "event"))
    List<Compilation> compilationList;
}
