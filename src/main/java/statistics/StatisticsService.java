package main.java.statistics;

import main.java.logger.ServletLogger;

import javax.servlet.ServletRequest;
import java.io.PrintWriter;
import java.util.logging.Level;

public final class StatisticsService {
    private static final StatisticsProcessor PROCESSOR = new StatisticsProcessor();
    private static final ServletLogger LOGGER = new ServletLogger();

    public static synchronized void collectStatistics() {
        try {
            PROCESSOR.collectStatistics();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.toString(), e);
        }
    }

    public static synchronized void getStatistics(final PrintWriter writer) {
        StatisticsInfo info = PROCESSOR.getStatistics();
        StatisticsFormatter formatter = new StatisticsFormatter();
        formatter.formatStatistics(info, writer);
    }

    public static synchronized boolean needStatistics(final ServletRequest request) {
        String parameter = request.getParameter("statistics");
        return  parameter != null && parameter.equals("1");
    }
}
