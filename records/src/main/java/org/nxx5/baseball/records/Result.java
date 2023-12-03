package org.nxx5.baseball.records;

public record Result(String type, String event, String eventType, String description, Long rbi, Long awayScore, Long homeScore, Boolean isOut) {
}
