package org.nxx5.baseball.records;

import java.time.OffsetDateTime;

public record About(Long atBatIndex, String halfInning, Boolean isTopInning, Long inning, OffsetDateTime startTime, OffsetDateTime endTime, Boolean isComplete, Boolean isScoringPlay, Boolean hasReview, Boolean hasOut, Long captivatingIndex) {
}
