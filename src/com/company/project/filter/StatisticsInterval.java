package com.company.project.filter;

import java.time.Duration;
import java.time.Instant;

public class StatisticsInterval{
    private Duration intervalDuration = Duration.ofMinutes(1);
    private Instant intervalStartTime = Instant.now();

    public void reset(){
        intervalStartTime = Instant.now();
    }

    public void setIntervalDuration(Duration duration){
        intervalDuration = duration;
    }

    public boolean isIntervalFinished(){
        Duration difference = intervalDuration.minus(Duration.between(intervalStartTime, Instant.now()));
        return difference.isNegative();
    }
}
