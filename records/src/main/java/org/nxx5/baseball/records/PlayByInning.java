package org.nxx5.baseball.records;

import java.util.List;

public record PlayByInning(Long startIndex, Long endIndex, List<Long> top, List<Long> bottom, Hits hits) {
}
