package com.company.project.filter;

import com.company.project.logger.ServletLogger;
import com.company.project.statistics.StatisticsService;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.logging.Level;

@javax.servlet.annotation.WebFilter(filterName = "statistics filter")
public final class StatisticsFilter implements Filter {
    private final StatisticsService statisticsService = new StatisticsService();
    private final ServletLogger logger = new ServletLogger();

    @Override
    public void init(final FilterConfig config) throws ServletException {
    }

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
            throws IOException, ServletException {
        try {
            if (statisticsService.needStatistics(request)) {
                statisticsService.getStatistics(response.getWriter());
                return;
            }

            chain.doFilter(request, response);
            statisticsService.collectStatistics();
        } catch (Exception e) {
            logger.log(Level.WARNING, e.toString(), e);
        }
    }

    @Override
    public void destroy() {
    }
}
