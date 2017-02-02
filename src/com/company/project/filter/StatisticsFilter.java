package com.company.project.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

@javax.servlet.annotation.WebFilter(filterName = "statistics filter")
public class StatisticsFilter implements Filter
{
    private final StatisticsProcessor statisticsProcessor = new StatisticsProcessor();

    private void collectStatistics(){
        try {
            statisticsProcessor.CollectStatistics();
        }
        catch (Exception e) {
            System.out.println("Exception raised: " + e.getMessage());
        }
    }

    private void getStatistics(ServletResponse response) {
        StatisticsInfo info = statisticsProcessor.GetStatistics();
        StatisticsFormatter formatter = new StatisticsFormatter();
        formatter.formatStatistics(info, response);
    }

    private boolean needStatistics (ServletRequest request) {
        String parameter = request.getParameter("statistics");
        return  parameter != null && parameter.equals("1");
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        try {
            if (needStatistics(request)) {
                getStatistics(response);
                return;
            }

            chain.doFilter(request, response);
            collectStatistics();
        }
        catch (Exception e) {
            System.out.println("Exception raised: " + e.getMessage());
        }
    }

    @Override
    public void destroy() {
    }
}
