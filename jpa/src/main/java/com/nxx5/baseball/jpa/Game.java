package com.nxx5.baseball.jpa;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.*;

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

    @OneToMany(cascade = CascadeType.MERGE)
    private Set<Play> plays = new HashSet<>();

    @OneToMany(cascade = CascadeType.MERGE)
    private Set<GamePosition> gamePositions = new HashSet<>();

    @OneToMany(cascade = CascadeType.MERGE)
    private Set<Batter> batters = new HashSet<>();

    @OneToMany(cascade = CascadeType.MERGE)
    private Set<Pitcher> pitchers = new HashSet<>();

    @OneToMany(cascade = CascadeType.MERGE)
    private Set<Bench> bench = new HashSet<>();

    @OneToMany(cascade = CascadeType.MERGE)
    private Set<Bullpen> bullpen = new HashSet<>();

    @OneToMany(cascade = CascadeType.MERGE)
    private Set<BattingOrder> battingOrder = new HashSet<>();

    public void addBattingOrder(BattingOrder b){
        if(battingOrder != null){
            b.setGame(this);
            battingOrder.add(b);
        }
    }

    public void setBattingOrder(Set<BattingOrder> battingOrder) {
        battingOrder.forEach(this::addBattingOrder);
    }

    public void addBullpen(Bullpen b){
        if(bullpen != null){
            b.setGame(this);
            bullpen.add(b);
        }
    }

    public void setBullpen(Set<Bullpen> bullpen) {
        bullpen.forEach(this::addBullpen);
    }

    public void addBench(Bench b){
        if(bench != null){
            b.setGame(this);
            bench.add(b);
        }
    }

    public void setBench(Set<Bench> bench) {
        bench.forEach(this::addBench);
    }

    public void addPitcher(Pitcher pitcher){
        if(pitchers != null){
            pitcher.setGame(this);
            pitchers.add(pitcher);
        }
    }

    public void setPitchers(Set<Pitcher> pitchers) {
        pitchers.forEach(this::addPitcher);
    }

    public void addBatter(Batter batter){
        if(batters != null){
            batter.setGame(this);
            batters.add(batter);
        }
    }

    public void setBatters(Set<Batter> batters) {
        batters.forEach(this::addBatter);
    }

    public void addPlay(Play play){
        if(plays != null){
            plays.add(play);
            play.setGame(this);
        }
    }

    public void setPlays(Set<Play> plays) {
        plays.forEach(this::addPlay);
    }

    public void addGamePosition(GamePosition position){
        if(gamePositions != null){
            position.setGame(this);
            gamePositions.add(position);
        }
    }

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
