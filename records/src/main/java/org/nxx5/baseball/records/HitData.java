package org.nxx5.baseball.records;

public record HitData(Double launchSpeed, Double launchAngle, Double totalDistance, String trajectory, String hardness, String location, HitDataCoordinates coordinates) {
}
