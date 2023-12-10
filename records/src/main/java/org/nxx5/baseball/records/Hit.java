package org.nxx5.baseball.records;

public record Hit(Team team, Long inning, Person pitcher, Person batter, FieldedCoordinates coordinates, String type, String description) {
}
