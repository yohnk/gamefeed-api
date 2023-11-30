package org.nxx5.baseball.records;

import java.util.List;

// Needs to be a POJO since "wait" is a reserved name with java records.
public class MetaData {

    private Long wait;
    private String timeStamp;
    private List<String> gameEvents;
    private List<String> logicalEvents;

    public MetaData() {
    }

    public MetaData(Long wait, String timeStamp, List<String> gameEvents, List<String> logicalEvents) {
        this.wait = wait;
        this.timeStamp = timeStamp;
        this.gameEvents = gameEvents;
        this.logicalEvents = logicalEvents;
    }

    public Long getWait() {
        return wait;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public List<String> getGameEvents() {
        return gameEvents;
    }

    public List<String> getLogicalEvents() {
        return logicalEvents;
    }

    public void setWait(Long wait) {
        this.wait = wait;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setGameEvents(List<String> gameEvents) {
        this.gameEvents = gameEvents;
    }

    public void setLogicalEvents(List<String> logicalEvents) {
        this.logicalEvents = logicalEvents;
    }
}
