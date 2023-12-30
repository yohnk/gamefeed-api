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
        if(Objects.isNull(game)){
            return null;
        }
        else {
            return game.getGamePk();
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

}
