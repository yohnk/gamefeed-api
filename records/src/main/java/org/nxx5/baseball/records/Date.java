package org.nxx5.baseball.records;

import java.time.LocalDate;
import java.util.List;

public record Date(LocalDate date, Long totalItems, Long totalEvents, Long totalGames, Long totalGamesInProgress, List<ScheduledGame> games) {
}
