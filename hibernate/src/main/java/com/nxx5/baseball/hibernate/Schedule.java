package com.nxx5.baseball.hibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @EqualsAndHashCode
@Entity(name = "schedule")
public class Schedule {

    @Id
    @NonNull
    private Long gamePk;

    @Column
    private String gameGuid;

    @Column
    private String link;

    @Column
    private String gameType;

    @Column
    private Long season;

    @Column
    private OffsetDateTime gameDate;

    @Column
    private LocalDate officialDate;

    @Column
    private String abstractGameState;

    @Column
    private String codedGameState;

    @Column
    private String detailedState;

    @Column
    private String statusCode;

    @Column
    private Boolean startTimeTBD;

    @Column
    private String abstractGameCode;

    @ManyToOne
    @Cascade(CascadeType.MERGE)
    private Team awayTeam;

    @ManyToOne
    @Cascade(CascadeType.MERGE)
    private Team homeTeam;

    @ManyToOne
    @Cascade(CascadeType.MERGE)
    private Venue venue;

    @Column
    private Boolean isTie;

    @Column
    private Long gameNumber;

    @Column
    private Boolean doubleHeader;

    @Column
    private String gamedayType;

    @Column
    private Boolean tiebreaker;

    @Column
    private String calendarEventID;

    @Column
    private String seasonDisplay;

    @Column
    private String dayNight;

    @Column
    private String description;

    @Column
    private Long scheduledInnings;

    @Column
    private Boolean reverseHomeAwayStatus;

    @Column
    private Long inningBreakLength;

    @Column
    private Long gamesInSeries;

    @Column
    private Long seriesGameNumber;

    @Column
    private String seriesDescription;

    @Column
    private String recordSource;

    @Column
    private Boolean ifNecessary;

    @Column
    private String ifNecessaryDescription;

}
