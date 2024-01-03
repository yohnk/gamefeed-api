package com.nxx5.baseball.hibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity(name = "person")
public class Person {

    @Id
    private Long id;

    @Column
    private String fullName;

    @Column
    private String link;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private Long primaryNumber;

    @Column
    private LocalDate birthDate;

    @Column
    private Long currentAge;

    @Column
    private String birthCity;

    @Column
    private String birthStateProvince;

    @Column
    private String birthCountry;

    @Column
    private String height;

    @Column
    private Long weight;

    @Column
    private Boolean active;

    @ManyToOne
    private Position primaryPosition;

    @Column
    private String useName;

    @Column
    private String useLastName;

    @Column
    private String middleName;

    @Column
    private String boxscoreName;

    @Column
    private String nickName;

    @Column
    private String gender;

    @Column
    private Boolean isPlayer;

    @Column
    private Boolean isVerified;

    @Column
    private Long draftYear;

    @Column
    private String pronunciation;

    @Column
    private LocalDate mlbDebutDate;

    @Column
    private String batSideCode;

    @Column
    private String batSideDescription;

    @Column
    private String pitchHandCode;

    @Column
    private String pitchHandDescription;

    @Column
    private String nameFirstLast;

    @Column
    private String nameSlug;

    @Column
    private String firstLastName;

    @Column
    private String lastFirstName;

    @Column
    private String lastInitName;

    @Column
    private String initLastName;

    @Column
    private String fullFMLName;

    @Column
    private String fullLFMName;

    @Column
    private Double strikeZoneTop;

    @Column
    private Double strikeZoneBottom;

}
