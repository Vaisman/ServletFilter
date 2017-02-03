package com.company.project.statistics;

public final class StatisticsInfo {
    private final Integer statisticsHours = 12;
    private final QueueList<Integer> queue = new QueueList(statisticsHours);
    private Integer callsCount = 0;

    public void reset() {
        callsCount = 1;
        queue.add(callsCount);
    }

    public void update() {
        callsCount++;
        if (queue.size() == 0) {
            queue.add(callsCount);
        } else {
            queue.set(0, callsCount);
        }
    }

    public QueueList<Integer> getStatistics() {
        return queue;
    }
}
