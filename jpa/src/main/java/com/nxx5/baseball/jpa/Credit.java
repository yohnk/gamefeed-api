package com.nxx5.baseball.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity(name = "credit")
@RequiredArgsConstructor
public class Credit {

    @Id
    @ManyToOne
    @EqualsAndHashCode.Exclude
    @NonNull
    private Runner runner;

    @Id
    @ManyToOne
    @EqualsAndHashCode.Exclude
    @NonNull
    private Person player;

    @ManyToOne
    private Position position;

    @Column
    private String credit;

    @EqualsAndHashCode.Include
    private Long gameId(){
        return runner == null ? null : runner.gameId();
    }

    @EqualsAndHashCode.Include
    private Long atBatIndex(){
        return runner == null ? null : runner.atBatIndex();
    }

    @EqualsAndHashCode.Include
    private Long runnerId(){
        return runner == null ? null : runner.runnerId();
    }

    @EqualsAndHashCode.Include
    private Long playerId(){
        return player == null ? null : player.getId();
    }

}
