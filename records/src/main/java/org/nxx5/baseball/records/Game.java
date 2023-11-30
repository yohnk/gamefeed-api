package org.nxx5.baseball.records;

public record Game(Long pk, String type, String doubleHeader, String id, String gamedayType, String tiebreaker, Long gameNumber, String calendarEventID, String season, String seasonDisplay) {
}
