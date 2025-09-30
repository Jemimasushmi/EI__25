package com.astronaut;

import com.astronaut.model.Task;
import com.astronaut.model.PriorityLevel;
import com.astronaut.service.ScheduleManager;
import com.astronaut.service.ConflictNotifier;
import com.astronaut.exception.ScheduleException;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final ScheduleManager scheduleManager = ScheduleManager.getInstance();
    private static final ConflictNotifier notifier = new ConflictNotifier();
    private static final Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

    public static void main(String[] args) {
        scheduleManager.registerObserver(notifier);
        showWelcomeMessage();
        runApplication();
        scanner.close();
    }

    private static void showWelcomeMessage() {
        System.out.println("ASTRONAUT DAILY SCHEDULE ORGANIZER");
        System.out.println("Welcome to the Space Mission Scheduling System!");
        System.out.println();
    }

    private static void runApplication() {
        boolean running = true;
        
        while (running) {
            try {
                showMenu();
                int choice = readIntInput("Enter your choice (1-6): ");
                running = handleChoice(choice);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println();
        }
        System.out.println("Thank you for using Astronaut Schedule Organizer. Safe travels! ");
    }

    private static void showMenu() {
        System.out.println("Main Menu:");
        System.out.println("1. Add New Task");
        System.out.println("2. Remove Task");
        System.out.println("3. View All Tasks");
        System.out.println("4. View Tasks by Priority");
        System.out.println("5. Mark Task as Completed");
        System.out.println("6. Exit");
    }

    private static boolean handleChoice(int choice) throws ScheduleException {
        switch (choice) {
            case 1: addTask(); break;
            case 2: removeTask(); break;
            case 3: viewAllTasks(); break;
            case 4: viewTasksByPriority(); break;
            case 5: markTaskCompleted(); break;
            case 6: return false;
            default: System.out.println("Invalid choice. Try again.");
        }
        return true;
    }

    private static void addTask() throws ScheduleException {
        System.out.println("\n--- Add New Task ---");
        String description = readStringInput("Enter task description: ");
        LocalTime startTime = readTimeInput("Enter start time (HH:mm): ");
        LocalTime endTime = readTimeInput("Enter end time (HH:mm): ");
        PriorityLevel priority = readPriorityInput();

        Task task = scheduleManager.addTask(description, startTime, endTime, priority);
        System.out.println(" Task added! ID: " + task.getId());
    }

    private static void removeTask() {
        System.out.println("\n--- Remove Task ---");
        viewAllTasks();
        if (scheduleManager.isEmpty()) return;
        
        String taskId = readStringInput("Enter task ID to remove: ");
        if (scheduleManager.removeTask(taskId)) {
            System.out.println("Task removed");
        } else {
            System.out.println("Task not found");
        }
    }

    private static void viewAllTasks() {
        System.out.println("\n--- All Tasks ---");
        List<Task> tasks = scheduleManager.getAllTasks();
        
        if (tasks.isEmpty()) {
            System.out.println("No tasks scheduled.");
            return;
        }

        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    private static void viewTasksByPriority() {
        System.out.println("\n--- Tasks by Priority ---");
        PriorityLevel priority = readPriorityInput();
        List<Task> tasks = scheduleManager.getTasksByPriority(priority);
        
        if (tasks.isEmpty()) {
            System.out.println("No tasks with " + priority + " priority.");
            return;
        }

        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    private static void markTaskCompleted() {
        System.out.println("\n--- Mark Task Completed ---");
        viewAllTasks();
        if (scheduleManager.isEmpty()) return;
        
        String taskId = readStringInput("Enter task ID to mark completed: ");
        if (scheduleManager.markTaskAsCompleted(taskId)) {
            System.out.println("Task marked as completed");
        } else {
            System.out.println(" Task not found");
        }
    }

    // Helper methods
    private static String readStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static int readIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }

    private static LocalTime readTimeInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine().trim();
                return LocalTime.parse(input, timeFormatter);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid time format. Use HH:mm (e.g., 09:30)");
            }
        }
    }

    private static PriorityLevel readPriorityInput() {
        while (true) {
            System.out.print("Enter priority (LOW/MEDIUM/HIGH/CRITICAL): ");
            String input = scanner.nextLine().trim().toUpperCase();
            try {
                return PriorityLevel.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid priority. Choose from: LOW, MEDIUM, HIGH, CRITICAL");
            }
        }
    }
}