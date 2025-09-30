package com.astronaut.model;

import java.time.LocalTime;
import java.util.Objects;
import java.util.UUID;

public class Task {
    private final String id;
    private String description;
    private LocalTime startTime;
    private LocalTime endTime;
    private PriorityLevel priority;
    private boolean isCompleted;

    public Task(String description, LocalTime startTime, LocalTime endTime, PriorityLevel priority) {
        this.id = UUID.randomUUID().toString();
        setDescription(description);
        setStartTime(startTime);
        setEndTime(endTime);
        setPriority(priority);
        this.isCompleted = false;
        validate();
    }

    public String getId() { return id; }
    public String getDescription() { return description; }
    public LocalTime getStartTime() { return startTime; }
    public LocalTime getEndTime() { return endTime; }
    public PriorityLevel getPriority() { return priority; }
    public boolean isCompleted() { return isCompleted; }

    public void setDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Task description cannot be empty");
        }
        this.description = description.trim();
    }

    public void setStartTime(LocalTime startTime) {
        if (startTime == null) throw new IllegalArgumentException("Start time cannot be null");
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime) {
        if (endTime == null) throw new IllegalArgumentException("End time cannot be null");
        this.endTime = endTime;
    }

    public void setPriority(PriorityLevel priority) {
        if (priority == null) throw new IllegalArgumentException("Priority cannot be null");
        this.priority = priority;
    }

    public void setCompleted(boolean completed) { isCompleted = completed; }

    private void validate() {
        if (startTime.isAfter(endTime) || startTime.equals(endTime)) {
            throw new IllegalArgumentException("Start time must be before end time");
        }
    }

    public boolean overlapsWith(Task other) {
        return this.startTime.isBefore(other.endTime) && other.startTime.isBefore(this.endTime);
    }

    @Override
    public String toString() {
        return String.format("%s - %s: %s [%s] %s", 
            startTime, endTime, description, priority, 
            isCompleted ? "[Completed]" : "");
    }
}