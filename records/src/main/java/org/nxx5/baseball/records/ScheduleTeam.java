package org.nxx5.baseball.records;

public record ScheduleTeam(LeagueRecord leagueRecord, Long score, Team team, Boolean isWinner, Boolean splitSquad, Long seriesNumber) {
}
