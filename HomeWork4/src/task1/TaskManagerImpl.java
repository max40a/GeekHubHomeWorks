package task1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class TaskManagerImpl implements TaskManager {

    private Map<LocalDateTime, Task> taskStore = new TreeMap<>();

    @Override
    public void add(LocalDateTime date, Task task) {
        taskStore.put(date, task);
    }

    @Override
    public void remove(LocalDateTime date) {
        taskStore.remove(date);
    }

    @Override
    public Set<String> getCategories() {
        Set<String> result = new TreeSet<>();
        for (Task task : taskStore.values()) {
            result.add(task.getCategory());
        }
        return result;
    }

    @Override
    public Map<String, List<Task>> getTasksByCategories(String... categories) {
        Map<String, List<Task>> result = new TreeMap<>();

        for (String category : categories) {
            result.put(category, getTasksByCategory(category));
        }

        return result;
    }

    @Override
    public List<Task> getTasksByCategory(String category) {
        List<Task> result = new ArrayList<>();
        for (Task task : taskStore.values()) {
            if (task.getCategory().equals(category)) {
                result.add(task);
            }
        }
        return result;
    }

    @Override
    public List<Task> getTasksForToday() {
        List<Task> tasksForToday = new ArrayList<>();
        LocalDate today = LocalDate.now();
        for (Map.Entry<LocalDateTime, Task> entry : taskStore.entrySet()) {
            LocalDateTime taskDate = entry.getKey();
            if (today.isEqual(entry.getKey().toLocalDate())) {
                tasksForToday.add(taskStore.get(taskDate));
            }
        }
        return tasksForToday;
    }
}