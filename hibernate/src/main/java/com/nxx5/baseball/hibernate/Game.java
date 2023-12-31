package com.nxx5.baseball.hibernate;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

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

    @EqualsAndHashCode.Include
    private Long venueId(){
        if(Objects.isNull(venue)){
            return null;
        }
        else {
            return venue.getId();
        }
    }

    @EqualsAndHashCode.Include
    private Long awayId(){
        if(Objects.isNull(away)){
            return null;
        }
        else {
            return away.getId();
        }
    }

    @EqualsAndHashCode.Include
    private Long homeId(){
        if(Objects.isNull(home)){
            return null;
        }
        else {
            return home.getId();
        }
    }

    @EqualsAndHashCode.Include
    private String statusId(){
        if(Objects.isNull(status)){
            return null;
        }
        else {
            return status.getStatusCode();
        }
    }

    @EqualsAndHashCode.Include
    private String typeId(){
        if(Objects.isNull(type)){
            return null;
        }
        else {
            return type.getId();
        }
    }
}