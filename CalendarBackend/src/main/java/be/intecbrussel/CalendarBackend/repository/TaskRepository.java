package be.intecbrussel.CalendarBackend.repository;

import be.intecbrussel.CalendarBackend.model.CalenderTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<CalenderTask, Long> {
}
