package com.astronaut.service;

import com.astronaut.observer.ScheduleObserver;
import com.astronaut.logger.Logger;

public class ConflictNotifier implements ScheduleObserver {
    private final Logger logger = Logger.getInstance();

    @Override
    public void update(String message) {
        logger.logWarning("NOTIFICATION: " + message);
    }
}