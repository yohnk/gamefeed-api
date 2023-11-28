package org.nxx5.baseball.records;

import java.time.LocalDate;
import java.time.OffsetDateTime;

public record DateTime(OffsetDateTime dateTime, LocalDate originalDate, LocalDate officialDate, String dayNight, String time, String ampm) {
}
