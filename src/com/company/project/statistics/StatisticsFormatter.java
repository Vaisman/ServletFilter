package com.company.project.statistics;

import java.io.PrintWriter;

public final class StatisticsFormatter {

    public void formatStatistics(final StatisticsInfo info, final PrintWriter writer) {
        QueueList<Integer> queue = info.getStatistics();

        writer.println("Hour  Calls");

        int i = 0;
        for (Integer item : queue) {
            writer.println(i++ + "       " + item);
        }
    }
}
