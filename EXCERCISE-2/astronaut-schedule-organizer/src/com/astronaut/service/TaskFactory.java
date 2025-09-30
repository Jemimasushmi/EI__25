package com.astronaut.service;

import com.astronaut.model.Task;
import com.astronaut.model.PriorityLevel;
import java.time.LocalTime;

public class TaskFactory {
    private TaskFactory() {}

    public static Task createTask(String description, LocalTime startTime, 
                                 LocalTime endTime, PriorityLevel priority) {
        return new Task(description, startTime, endTime, priority);
    }
}