package com.company.project.filter;

import javax.servlet.ServletResponse;
import java.io.IOException;

public class StatisticsFormatter {

    public void formatStatistics(StatisticsInfo info, ServletResponse response){
        try {
            QueueList<Integer> queue = info.getStatistics();

            response.getWriter().println("Hour  Calls");

            int i = 0;
            for (Integer item : queue) {
                response.getWriter().println(i++ + "       " + item);
            }
        }
        catch (IOException e) {
            System.out.println("Exception raised: " + e.getMessage());
        }
    }
}
