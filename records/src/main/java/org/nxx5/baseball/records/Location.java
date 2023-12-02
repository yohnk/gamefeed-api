package org.nxx5.baseball.records;

public record Location(String address1, String city, String state, String stateAbbrev, String postalCode, Coordinates defaultCoordinates, Double azimuthAngle, Long elevation, String country, String phone) {
}
