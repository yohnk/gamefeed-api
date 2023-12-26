package org.nxx5.baseball.records;

import java.util.List;

public record BoxScorePlayer(Person person, String jerseyNumber, Position position, PlayerStatus status, Long parentTeamId, String battingOrder, List<Position> allPositions) {
}
