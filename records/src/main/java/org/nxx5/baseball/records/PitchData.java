package org.nxx5.baseball.records;

public record PitchData(Double startSpeed, Double endSpeed, Double strikeZoneTop, Double strikeZoneBottom, PitchCoordinates coordinates, Breaks breaks, Long zone, Double typeConfidence, Double plateTime, Double extension) {
}
