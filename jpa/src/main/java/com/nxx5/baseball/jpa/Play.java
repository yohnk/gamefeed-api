package com.nxx5.baseball.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.OffsetDateTime;

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
    private Person batter;

    @ManyToOne
    private Person pitcher;

    @EqualsAndHashCode.Include
    protected Long gameId(){
        return game == null ? null : game.getGamePk();
    }

}
