package com.nxx5.baseball.hibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity(name = "probable_pitchers")
public class ProbablePitchers {

    @Id
    @OneToOne
    @EqualsAndHashCode.Exclude
    private Game game;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Person away;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Person home;

    @EqualsAndHashCode.Include
    private Long gameId(){
        return game == null ? null : game.getGamePk();
    }

    @EqualsAndHashCode.Include
    private Long awayId(){
        return away == null ? null : away.getId();
    }

    @EqualsAndHashCode.Include
    private Long homeId(){
        return home == null ? null : home.getId();
    }

}
