package com.nxx5.baseball.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity(name = "game_position")
public class GamePosition {

    @Id
    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Game game;

    @Id
    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Person batter;

    @Id
    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Team team;

    @Id
    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Position position;

    @EqualsAndHashCode.Include
    public Long gameId(){
        return game == null ? null : game.getGamePk();
    }

    @EqualsAndHashCode.Include
    public Long batterId(){
        return batter == null ? null : batter.getId();
    }

    @EqualsAndHashCode.Include
    public Long teamId(){
        return team == null ? null : team.getId();
    }

    @EqualsAndHashCode.Include
    public String positionId(){
        return position == null ? null : position.getCode();
    }


}
