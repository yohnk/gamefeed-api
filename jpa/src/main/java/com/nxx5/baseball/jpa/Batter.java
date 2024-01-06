package com.nxx5.baseball.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@Entity(name = "batter")
public class Batter {

    @Id
    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Game game;

    @Id
    @ManyToOne
    @EqualsAndHashCode.Exclude
    @NonNull
    private Person batter;

    @Id
    @ManyToOne
    @EqualsAndHashCode.Exclude
    @NonNull
    private Team team;

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


}
