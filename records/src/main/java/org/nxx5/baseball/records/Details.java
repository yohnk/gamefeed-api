package org.nxx5.baseball.records;

public record Details(Call call, String description, String code, String ballColor, String trailColor, Boolean isInPlay, Boolean isStrike, Boolean isBall, PitchType type, Boolean isOut, Boolean hasReview, String event, String eventType, Long awayScore, Long homeScore, Boolean isScoringPlay) {
}
