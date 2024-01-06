package com.nxx5.baseball.jpa;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(cascade = CascadeType.MERGE)
    private Set<Credit> credits = new HashSet<>();

    public void addCredit(Credit credit){
        if(credits != null){
            credit.setRunner(this);
            credits.add(credit);
        }
    }

    public void setCredits(Set<Credit> credits) {
        credits.forEach(this::addCredit);
    }

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
