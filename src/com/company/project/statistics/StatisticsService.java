package com.company.project.statistics;

import com.company.project.logger.ServletLogger;

import javax.servlet.ServletRequest;
import java.io.PrintWriter;
import java.util.logging.Level;

public final class StatisticsService {
    private final StatisticsProcessor statisticsProcessor = new StatisticsProcessor();
    private final ServletLogger logger = new ServletLogger();

    public void collectStatistics() {
        try {
            statisticsProcessor.collectStatistics();
            throw new Exception("dfs");
        } catch (Exception e) {
            logger.log(Level.WARNING, e.toString(), e);
        }
    }

    public void getStatistics(final PrintWriter writer) {
        StatisticsInfo info = statisticsProcessor.getStatistics();
        StatisticsFormatter formatter = new StatisticsFormatter();
        formatter.formatStatistics(info, writer);
    }

    public boolean needStatistics(final ServletRequest request) {
        String parameter = request.getParameter("statistics");
        return  parameter != null && parameter.equals("1");
    }
}
