package com.astronaut.service;

import com.astronaut.model.Task;
import com.astronaut.model.PriorityLevel;
import com.astronaut.observer.ScheduleObserver;
import com.astronaut.exception.ScheduleException;
import com.astronaut.logger.Logger;

import java.time.LocalTime;
import java.util.*;

public class ScheduleManager {
    private static ScheduleManager instance;
    private final List<Task> tasks = new ArrayList<>();
    private final List<ScheduleObserver> observers = new ArrayList<>();
    private final Logger logger = Logger.getInstance();

    private ScheduleManager() {}

    public static synchronized ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public void registerObserver(ScheduleObserver observer) {
        observers.add(observer);
        logger.logInfo("Observer registered: " + observer.getClass().getSimpleName());
    }

    private void notifyObservers(String message) {
        for (ScheduleObserver observer : observers) {
            observer.update(message);
        }
    }
    public Task addTask(String description, LocalTime startTime, LocalTime endTime, PriorityLevel priority) throws ScheduleException {
        try {
            Task newTask = TaskFactory.createTask(description, startTime, endTime, priority);
            
            if (hasTimeConflict(newTask)) {
                String message = "Task conflict detected: " + description;
                logger.logWarning(message);
                notifyObservers(message);
                throw new ScheduleException(message);
            }

            tasks.add(newTask);
            Collections.sort(tasks, Comparator.comparing(Task::getStartTime));
            
            logger.logInfo("Task added: " + description);
            return newTask;
        } catch (IllegalArgumentException e) {
            throw new ScheduleException("Invalid task: " + e.getMessage());
        }
    }

    public boolean removeTask(String taskId) {
        for (Task task : tasks) {
            if (task.getId().equals(taskId)) {
                tasks.remove(task);
                logger.logInfo("Task removed: " + task.getDescription());
                return true;
            }
        }
        return false;
    }

    public boolean markTaskAsCompleted(String taskId) {
        for (Task task : tasks) {
            if (task.getId().equals(taskId)) {
                task.setCompleted(true);
                logger.logInfo("Task completed: " + task.getDescription());
                return true;
            }
        }
        return false;
    }

    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }

    public List<Task> getTasksByPriority(PriorityLevel priority) {
        List<Task> result = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getPriority() == priority) {
                result.add(task);
            }
        }
        Collections.sort(result, Comparator.comparing(Task::getStartTime));
        return result;
    }

    public Task getTaskById(String taskId) {
        for (Task task : tasks) {
            if (task.getId().equals(taskId)) {
                return task;
            }
        }
        return null;
    }

    private boolean hasTimeConflict(Task newTask) {
        for (Task existingTask : tasks) {
            if (newTask.overlapsWith(existingTask)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return tasks.isEmpty();
    }
}