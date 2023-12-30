package com.nxx5.baseball.hibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity(name = "game_status")
public class GameStatus {

    @Column
    private String abstractGameState;

    @Column
    private String codedGameState;

    @Column
    private String detailedState;

    @Id
    private String statusCode;

    @Column
    private Boolean startTimeTBD;

    @Column
    private String abstractGameCode;

}
