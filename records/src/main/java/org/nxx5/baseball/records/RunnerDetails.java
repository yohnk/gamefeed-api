package org.nxx5.baseball.records;

public record RunnerDetails(String event, String eventType, String movementReason, Person runner, Person responsiblePitcher, Boolean isScoringEvent, Boolean rbi, Boolean earned, Boolean teamUnearned, Long playIndex) {
}
