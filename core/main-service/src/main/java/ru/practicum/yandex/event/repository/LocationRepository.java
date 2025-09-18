package ru.practicum.yandex.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.practicum.yandex.event.model.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}
