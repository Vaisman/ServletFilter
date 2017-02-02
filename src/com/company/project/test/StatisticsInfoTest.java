package com.company.project.test;

import com.company.project.filter.StatisticsInfo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StatisticsInfoTest {

    @Test
    public void testStatisticsInfo() {
        StatisticsInfo info = new StatisticsInfo();
        assertEquals("[]", info.getStatistics().toString());

        info.update();
        assertEquals("[1]", info.getStatistics().toString());

        info.update();
        assertEquals("[2]", info.getStatistics().toString());

        info.reset();
        assertEquals("[1, 2]", info.getStatistics().toString());

        info.update();
        info.reset();
        assertEquals("[1, 2, 2]", info.getStatistics().toString());
    }
}