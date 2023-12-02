package org.nxx5.baseball.records;

import java.time.LocalDate;

public record Person(Long id, String fullName, String link, String firstName, String lastName, String primaryNumber, LocalDate birthDate, Long currentAge, String birthCity, String birthStateProvince, String birthCountry, String height, Long weight, Boolean active, Position primaryPosition, String useName, String useLastName, String middleName, String boxscoreName, String gender, String nameMatrilineal, Boolean isPlayer, Boolean isVerified, String pronunciation, Long draftYear, LocalDate mlbDebutDate, Hand batSide, Hand pitchHand, String nameFirstLast, String nameSlug, String firstLastName, String lastFirstName, String lastInitName, String initLastName, String fullFMLName, String fullLFMName, Double strikeZoneTop, Double strikeZoneBottom) {
}
