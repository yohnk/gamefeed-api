package org.nxx5.baseball.records;

public record Team(League springLeague, String allStarStatus, Long id, String name, String link, Long season, Venue venue, Venue springVenue, String teamCode, String fileCode, String abbreviation, String teamName, String locationName, String firstYearOfPlay, League league, Division division, Sport sport, String shortName, Record record, String franchiseName, String clubName, Boolean active) {
}
