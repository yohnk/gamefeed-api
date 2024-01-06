package com.nxx5.baseball.jpa;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@RequiredArgsConstructor
@Entity(name = "play")
public class Play {

    @ManyToOne
    @Id
    @EqualsAndHashCode.Exclude
    @NonNull
    private Game game;

    @Id
    @NonNull
    private Long atBatIndex;

    @Column
    private String type;

    @Column
    private String event;

    @Column
    private String eventType;

    @Column
    private String description;

    @Column
    private Long rbi;

    @Column
    private Long awayScore;

    @Column
    private Long homeScore;

    @Column
    private Boolean isOut;

    @Column
    private String halfInning;

    @Column
    private Boolean isTopInning;

    @Column
    private Long inning;

    @Column
    private OffsetDateTime startTime;

    @Column
    private OffsetDateTime endTime;

    @Column
    private Boolean isComplete;

    @Column
    private Boolean isScoringPlay;

    @Column
    private Boolean hasReview;

    @Column
    private Boolean hasOut;

    @Column
    private Long captivatingIndex;

    @Column
    private Long balls;

    @Column
    private Long strikes;

    @Column
    private Long outs;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Person batter;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Person pitcher;

    @OneToMany(cascade = CascadeType.MERGE)
    private Set<Runner> runners = new HashSet<>();

    @OneToMany(cascade = CascadeType.MERGE)
    private Set<Event> events = new HashSet<>();

    public void addRunner(Runner r){
        if(runners != null){
            r.setPlay(this);
            runners.add(r);
        }
    }

    public void addEvent(Event e){
        if(events != null){
            e.setPlay(this);
            events.add(e);
        }
    }

    @EqualsAndHashCode.Include
    protected Long gameId(){
        return game == null ? null : game.getGamePk();
    }

    @EqualsAndHashCode.Include
    protected Long batterId(){
        return batter == null ? null : batter.getId();
    }

    @EqualsAndHashCode.Include
    protected Long pitcherId(){
        return pitcher == null ? null : pitcher.getId();
    }

}
