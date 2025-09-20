package practicum.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practicum.event.model.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}
