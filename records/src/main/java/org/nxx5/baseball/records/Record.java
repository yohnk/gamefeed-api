package org.nxx5.baseball.records;

public record Record(Long gamesPlayed, String wildCardGamesBack, String leagueGamesBack, String springLeagueGamesBack, String sportGamesBack, String divisionGamesBack, String conferenceGamesBack, LeagueRecord leagueRecord, Records records, Boolean divisionLeader, Long wins, Long losses, String winningPercentage) {
}
