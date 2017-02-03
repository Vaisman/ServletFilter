package main.java.filter;

import main.java.logger.ServletLogger;
import main.java.statistics.StatisticsService;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.logging.Level;

public final class StatisticsFilter implements Filter {
    private final ServletLogger logger = new ServletLogger();

    @Override
    public void init(final FilterConfig config) throws ServletException {
    }

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
            throws IOException, ServletException {
        try {
            chain.doFilter(request, response);
            StatisticsService.collectStatistics();
        } catch (Exception e) {
            logger.log(Level.WARNING, e.toString(), e);
        }
    }

    @Override
    public void destroy() {
    }
}
