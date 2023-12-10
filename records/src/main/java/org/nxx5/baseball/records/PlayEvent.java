package org.nxx5.baseball.records;

import java.time.OffsetDateTime;

public record PlayEvent(Details details, Count count, PitchData pitchData, Long index, String playId, Long pitchNumber, OffsetDateTime startTime, OffsetDateTime endTime, Boolean isPitch, String type) {
}
