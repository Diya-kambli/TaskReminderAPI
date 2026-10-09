package taskreminder;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private static List<Task> tasks = new ArrayList<>();

    public static void addTask(Task task) {
        tasks.add(task);
    }

    public static List<Task> getTasks() {
        return tasks;
    }

    public static void deleteTask(int index) {

        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        }
    }

    public static void completeTask(int index) {

        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).setStatus("Completed");
        }
    }

    public static void updateTask(int index, String taskName,
                                  String description, String date,
                                  String time, String priority) {

        if (index >= 0 && index < tasks.size()) {

            Task task = tasks.get(index);

            task.setTaskName(taskName);
            task.setDescription(description);
            task.setDate(date);
            task.setTime(time);
            task.setPriority(priority);
        }
    }
}