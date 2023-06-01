package be.intecbrussel.CalendarBackend.controller;

import be.intecbrussel.CalendarBackend.model.CalenderTask;
import be.intecbrussel.CalendarBackend.service.CalenderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/")
@CrossOrigin("http://localhost:4200")
public class CalenderController {
    private final CalenderService calenderService;

    public CalenderController(CalenderService calenderService) {
        this.calenderService = calenderService;
    }

    @GetMapping("/getTasks")
    public ResponseEntity getAllTasks() {
        return ResponseEntity.ok(calenderService.readAllTasks());
    }

    @PostMapping("/addTask")
    public ResponseEntity createNewTask(@RequestBody CalenderTask task) {
        Optional<CalenderTask> savedTask = calenderService.addTask(task);
        if (savedTask.isEmpty()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.ok(savedTask.get());
    }

    @PutMapping("/updateTask/{id}")
    public ResponseEntity updateTask(@RequestBody CalenderTask task) {
        Optional<CalenderTask> updatedTask = calenderService.updateTask(task);
        if (updatedTask.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedTask.get());
    }

    @DeleteMapping("/deleteTask/{id}")
    public ResponseEntity deleteTask(@RequestBody CalenderTask task) {
        Optional<CalenderTask> deletedTask = calenderService.deleteTask(task);
        if (deletedTask.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(deletedTask.get());
    }

}
