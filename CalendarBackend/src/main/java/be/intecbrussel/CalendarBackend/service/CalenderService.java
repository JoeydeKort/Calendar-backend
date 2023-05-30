package be.intecbrussel.CalendarBackend.service;

import be.intecbrussel.CalendarBackend.model.CalenderTask;

import java.util.List;
import java.util.Optional;

public interface CalenderService {
    Optional<CalenderTask> addTask(CalenderTask task);
    Optional<CalenderTask> updateTask(CalenderTask task);
    Optional<CalenderTask> deleteTask(CalenderTask task);
    List<CalenderTask> readAllTasks();
}
