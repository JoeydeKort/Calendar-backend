package be.intecbrussel.CalendarBackend.service;

import be.intecbrussel.CalendarBackend.model.CalenderTask;
import be.intecbrussel.CalendarBackend.repository.TaskRepository;
import be.intecbrussel.CalendarBackend.util.TaskValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalenderServiceImpl implements CalenderService{
    private final TaskRepository taskRepository;

    public CalenderServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Optional<CalenderTask> addTask(CalenderTask task) {
        boolean isTaskValid = TaskValidator.validateTask(task);
        if (!isTaskValid) return Optional.empty();

        CalenderTask saved = taskRepository.save(task);

        return saved.equals(task) ? Optional.of(saved) : Optional.empty();
    }

    @Override
    public Optional<CalenderTask> updateTask(CalenderTask task) {
        boolean isTaskValid = TaskValidator.validateTask(task);
        if (!isTaskValid) return Optional.empty();

        CalenderTask saved = taskRepository.save(task);

        return saved.equals(task) ? Optional.of(saved) : Optional.empty();
    }

    @Override
    public Optional<CalenderTask> deleteTask(CalenderTask task) {
        boolean isTaskValid = TaskValidator.validateTask(task);
        if (!isTaskValid) return Optional.empty();

        taskRepository.delete(task);

        return taskRepository.findById(task.getId()).isPresent() ? Optional.of(task) : Optional.empty();
    }

    @Override
    public List<CalenderTask> readAllTasks() {
        return taskRepository.findAll();
    }
}
