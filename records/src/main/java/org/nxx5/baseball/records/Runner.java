package org.nxx5.baseball.records;

import java.util.List;

public record Runner(Movement movement, RunnerDetails details, List<Credit> credits) {
}
