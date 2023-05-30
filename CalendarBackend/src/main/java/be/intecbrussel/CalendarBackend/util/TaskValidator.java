package be.intecbrussel.CalendarBackend.util;

import be.intecbrussel.CalendarBackend.model.CalenderTask;

public class TaskValidator {
    public static boolean validateTask(CalenderTask task) {
        return task.getStartDateTime().before(task.getEndDateTime());
    }
}
