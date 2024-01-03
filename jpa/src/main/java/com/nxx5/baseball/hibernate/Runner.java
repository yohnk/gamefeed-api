package com.nxx5.baseball.hibernate;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@Entity(name = "runner")
public class Runner {

    @ManyToOne
    @Id
    @EqualsAndHashCode.Exclude
    @NonNull
    private Play play;

    @ManyToOne
    @Id
    @EqualsAndHashCode.Exclude
    @NonNull
    private Person runner;

    @Column
    private String originBase;

    @Column(name = "start_base")
    private String start;

    @Column(name = "end_base")
    private String end;

    @Column
    private String outBase;

    @Column
    private Boolean isOut;

    @Column
    private Long outNumber;

    @Column
    private String event;

    @Column
    private String eventType;

    @Column
    private String movementReason;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Person responsiblePitcher;

    @Column
    private Boolean isScoringEvent;

    @Column
    private Boolean rbi;

    @Column
    private Boolean earned;

    @Column
    private Boolean teamUnearned;

    @Column
    private Long playIndex;

    @EqualsAndHashCode.Include
    protected Long gameId(){
        return play == null ? null : play.gameId();
    }

    @EqualsAndHashCode.Include
    protected Long atBatIndex(){
        return play == null ? null : play.getAtBatIndex();
    }

    @EqualsAndHashCode.Include
    protected Long runnerId(){
        return runner == null ? null : runner.getId();
    }

    @EqualsAndHashCode.Include
    private Long pitcherId(){
        return responsiblePitcher == null ? null : responsiblePitcher.getId();
    }

}
