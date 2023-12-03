package org.nxx5.baseball.records;

import java.util.List;

public record Play(Result result, About about, Count count, Matchup matchup, List<Long> pitchIndex, List<Long> actionIndex, List<Long> runnerIndex) {
}
