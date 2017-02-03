package com.company.project.logger;

import com.company.project.filter.StatisticsFilter;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.XMLFormatter;
import java.util.logging.Level;

public final class ServletLogger {
    private static final java.util.logging.Logger LOGGER =
            java.util.logging.Logger.getLogger(StatisticsFilter.class.getName());

    public ServletLogger() {
        Handler handler = null;

        try {
            handler = new FileHandler("servlet.log");
        } catch (IOException e) {
            System.out.println("Could not create file. Using the console handler");
            handler = new ConsoleHandler();
        }

       LOGGER.addHandler(handler);

        handler.setFormatter(new XMLFormatter());
    }

    public void log(final Level level, final String message, final Throwable throwable) {
        LOGGER.log(Level.WARNING, message, throwable);
    }
}
