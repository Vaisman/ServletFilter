package com.company.project.statistics;

public final class StatisticsProcessor {
    private final StatisticsInfo statisticsInfo = new StatisticsInfo();
    private final StatisticsInterval statisticsInterval = new StatisticsInterval();

    private void updateStatistics() {
        statisticsInfo.update();
    }

    private void resetInterval() {
        statisticsInfo.reset();
        statisticsInterval.reset();
    }

    public synchronized void collectStatistics() {
        if (statisticsInterval.isIntervalFinished()) {
            resetInterval();
        } else {
            updateStatistics();
        }
    }

    public synchronized StatisticsInfo getStatistics() {
        return statisticsInfo;
    }
}
