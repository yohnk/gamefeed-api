package com.nxx5.baseball.jpa;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Objects;

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

    @OneToOne(cascade = CascadeType.MERGE)
    private ProbablePitchers probablePitchers;

    public void setProbablePitchers(ProbablePitchers probablePitchers) {
        this.probablePitchers = probablePitchers;
        if(this.probablePitchers != null && this.probablePitchers.getGame() == null){
            this.probablePitchers.setGame(this);
        }
    }

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
