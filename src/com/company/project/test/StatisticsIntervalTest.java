package com.company.project.test;

import java.time.Duration;

import com.company.project.statistics.StatisticsInterval;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StatisticsIntervalTest {

    @Test
    public void testStatisticsInterval() {
        StatisticsInterval interval = new StatisticsInterval();

        try {
            interval.setIntervalDuration(Duration.ofSeconds(1));
            assertEquals(false, interval.isIntervalFinished());

            Thread.sleep(1500);
            assertEquals(true, interval.isIntervalFinished());
        } catch (InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
