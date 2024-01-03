package com.nxx5.baseball.hibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity(name = "season_info")
public class SeasonDateInfo {

    @Id
    @ManyToOne
    private League league;

    @Id
    private Long seasonId;

    @Column
    private LocalDate preSeasonStartDate;

    @Column
    private LocalDate preSeasonEndDate;

    @Column
    private LocalDate seasonStartDate;

    @Column
    private LocalDate springStartDate;

    @Column
    private LocalDate springEndDate;

    @Column
    private LocalDate regularSeasonStartDate;

    @Column
    private LocalDate lastDate1stHalf;

    @Column
    private LocalDate allStarDate;

    @Column
    private LocalDate firstDate2ndHalf;

    @Column
    private LocalDate regularSeasonEndDate;

    @Column
    private LocalDate postSeasonStartDate;

    @Column
    private LocalDate postSeasonEndDate;

    @Column
    private LocalDate seasonEndDate;

    @Column
    private LocalDate offseasonStartDate;

    @Column
    private LocalDate offSeasonEndDate;

    @Column
    private String seasonLevelGamedayType;

    @Column
    private String gameLevelGamedayType;

    @Column
    private Double qualifierPlateAppearances;

    @Column
    private Double qualifierOutsPitched;

}
