package com.company.project.test;

import com.company.project.statistics.StatisticsInfo;
import com.company.project.statistics.StatisticsProcessor;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StatisticsProcessorTest {

    private final int callsCount = 100;

    @Test
    public void testStatisticsProcessor() {
        StatisticsProcessor processor = new StatisticsProcessor();

        for (int i = 0; i < callsCount; i++) {
            processor.collectStatistics();
        }

        StatisticsInfo info = processor.getStatistics();
        assertEquals("[100]", info.getStatistics().toString());
    }

    private class MockThread extends Thread {

        private final StatisticsProcessor statisticsProcessor;

        MockThread(final StatisticsProcessor processor) {
            statisticsProcessor = processor;
        }

        public void run() {
            for (int i = 0; i < callsCount; i++) {
                statisticsProcessor.collectStatistics();
                statisticsProcessor.getStatistics();
            }
        }
    }

    @Test
    public void testStatisticsProcessorMultithreaded() {
        StatisticsProcessor processor = new StatisticsProcessor();

        try {
            MockThread t1 = new MockThread(processor);
            MockThread t2 = new MockThread(processor);

            t1.start();
            t2.start();
            t1.join();
            t2.join();

            StatisticsInfo info = processor.getStatistics();
            assertEquals("[200]", info.getStatistics().toString());
        } catch (InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
