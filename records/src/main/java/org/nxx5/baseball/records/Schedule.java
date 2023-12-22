package org.nxx5.baseball.records;

import java.util.List;

public record Schedule(String copyright, Long totalItems, Long totalEvents, Long totalGames, Long totalGamesInProgress, List<Date> dates) {
}
