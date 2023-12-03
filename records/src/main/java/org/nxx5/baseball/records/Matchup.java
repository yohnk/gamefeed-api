package org.nxx5.baseball.records;

import java.util.List;

public record Matchup(Person batter, Hand batSide, Person pitcher, Hand pitchHand, List<Object> batterHotColdZones, List<Object> pitcherHotColdZones, Splits splits) {
}
