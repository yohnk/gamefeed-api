package org.nxx5.baseball.records;

import java.time.OffsetDateTime;

public record GameInfo(Long attendance, OffsetDateTime firstPitch, Long gameDurationMinutes) {
}
