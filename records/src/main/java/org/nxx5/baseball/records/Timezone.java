package org.nxx5.baseball.records;

public record Timezone(String id, Long offset, Long offsetAtGameTime, String tz) {
}
