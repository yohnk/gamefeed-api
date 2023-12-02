package org.nxx5.baseball.records;

import java.util.List;

public record GameData(Game game, DateTime datetime, Status status, Teams teams, Players players, Venue venue, Venue officialVenue, Weather weather, GameInfo gameInfo, Review review, Flags flags, List<Object> alerts, ProbablePitchers probablePitchers, Person officialScorer, Person primaryDatacaster, MoundVisits moundVisits) {
}
