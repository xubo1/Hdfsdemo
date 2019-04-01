package com.example.demo.entity;

public class App {
    private int datasetId;
    private String timeInterval;
    private String startTime;
    private String endTime;
    private String supplementStrategy;

    public int getDatasetId() {
        return datasetId;
    }

    public void setDatasetId(int datasetId) {
        this.datasetId = datasetId;
    }

    public String getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(String timeInterval) {
        this.timeInterval = timeInterval;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getSupplementStrategy() {
        return supplementStrategy;
    }

    public void setSupplementStrategy(String supplementStrategy) {
        this.supplementStrategy = supplementStrategy;
    }
}
