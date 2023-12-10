package org.nxx5.baseball.records;

import java.time.OffsetDateTime;
import java.util.List;

public record Play(Result result, About about, Count count, Matchup matchup, List<Long> pitchIndex, List<Long> actionIndex, List<Long> runnerIndex, List<Runner> runners, List<PlayEvent> playEvents, OffsetDateTime playEndTime, Long atBatIndex) {
}
