package org.nxx5.baseball.records;

import java.util.List;

public record Plays(List<Play> allPlays, Play currentPlay, List<Long> scoringPlays, List<PlayByInning> playsByInning) {
}
