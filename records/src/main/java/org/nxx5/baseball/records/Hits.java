package org.nxx5.baseball.records;

import java.util.List;

public record Hits(List<Hit> away, List<Hit> home) {
}
