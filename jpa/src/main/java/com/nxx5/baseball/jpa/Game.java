package com.nxx5.baseball.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity(name = "game")
public class Game {

    @Id
    private Long gamePk;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private GameType type;

    @Column
    private Boolean doubleHeader;

    @Column
    private Boolean tiebreaker;

    @Column
    private Long gameNumber;

    @Column
    private Long season;

    @Column
    private String seasonDisplay;

    @Column
    private OffsetDateTime dateTime;

    @Column
    private LocalDate originalDate;

    @Column
    private LocalDate officialDate;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private GameStatus status;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Team away;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Team home;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Venue venue;

    @Column
    private String condition;

    @Column
    private Long temp;

    @Column
    private String wind;

    @Column
    private Long attendance;

    @Column
    private OffsetDateTime firstPitch;

    @Column
    private Long gameDurationMinutes;

    @EqualsAndHashCode.Include
    private Long venueId(){
        return venue == null ? null : venue.getId();
    }

    @EqualsAndHashCode.Include
    private Long awayId(){
        return away == null ? null : away.getId();
    }

    @EqualsAndHashCode.Include
    private Long homeId(){
        return home == null ? null : home.getId();
    }

    @EqualsAndHashCode.Include
    private String statusId(){
        return status == null ? null : status.getStatusCode();
    }

    @EqualsAndHashCode.Include
    private String typeId(){
        return type == null ? null : type.getId();
    }
}
