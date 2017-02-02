package com.company.project.filter;

public class StatisticsProcessor
{
    private final StatisticsInfo statisticsInfo = new StatisticsInfo();
    private final StatisticsInterval statisticsInterval = new StatisticsInterval();

    private void updateStatistics() {
        statisticsInfo.update();
    }

    private void resetInterval(){
        statisticsInfo.reset();
        statisticsInterval.reset();
    }

    public synchronized void CollectStatistics() {
        if (statisticsInterval.isIntervalFinished()) {
            resetInterval();
        }
        else {
            updateStatistics();
        }
    }

    public synchronized StatisticsInfo GetStatistics() {
        return statisticsInfo;
    }
}
