package org.nxx5.baseball.records;

import java.util.List;

public record BoxScoreTeam(Team team, TeamStats teamStats, BoxScorePlayers players, List<Long> batters, List<Long> pitchers, List<Long> bench, List<Long> bullpen, List<Long> battingOrder) {
}
