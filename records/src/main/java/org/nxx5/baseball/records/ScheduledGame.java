package org.nxx5.baseball.records;

import java.time.LocalDate;
import java.time.OffsetDateTime;

public record ScheduledGame(Long gamePk, String gameGuid, String link, String gameType, String season, OffsetDateTime gameDate, LocalDate officialDate, Status status, ScheduleTeams teams, Venue venue, Boolean isTie, Long gameNumber, Boolean publicFacing, String doubleHeader, String gamedayType, String tiebreaker, String calendarEventID, String seasonDisplay, String dayNight, String description, Long scheduledInnings, Boolean reverseHomeAwayStatus, Long inningBreakLength, Long gamesInSeries, Long seriesGameNumber, String seriesDescription, String recordSource, String ifNecessary, String ifNecessaryDescription) {
}
