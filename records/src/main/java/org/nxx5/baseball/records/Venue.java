package org.nxx5.baseball.records;

public record Venue(Long id, String name, String link, Location location, Timezone timeZone, FieldInfo fieldInfo, Boolean active, String season) {
}
