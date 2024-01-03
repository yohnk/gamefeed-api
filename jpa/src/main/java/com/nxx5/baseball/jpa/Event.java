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
@RequiredArgsConstructor
@EqualsAndHashCode
@Entity(name = "event")
public class Event {

    @ManyToOne
    @Id
    @EqualsAndHashCode.Exclude
    @NonNull
    private Play play;

    @Id
    @NonNull
    private Long index;

    @Column
    private String playId;

    @Column
    private Long pitchNumber;

    @Column
    private OffsetDateTime startTime;

    @Column
    private OffsetDateTime endTime;

    @Column
    private Boolean isPitch;

    @Column
    private String type;

    @Column
    private String callCode;

    @Column
    private String callDescription;

    @Column
    private String description;

    @Column
    private String code;

    @Column
    private Boolean isInPlay;

    @Column
    private Boolean isStrike;

    @Column
    private Boolean isBall;

    @Column
    private String pitchCode;

    @Column
    private String pitchDescription;

    @Column
    private Boolean isOut;

    @Column
    private Boolean hasReview;

    @Column
    private Long balls;

    @Column
    private Long strikes;

    @Column
    private Long outs;

    @Column
    private Double startSpeed;

    @Column
    private Double endSpeed;

    @Column
    private Double strikeZoneTop;

    @Column
    private Double strikeZoneBottom;

    @Column
    private Double aY;

    @Column
    private Double aZ;

    @Column
    private Double pfxX;

    @Column
    private Double pfxZ;

    @Column
    private Double pX;

    @Column
    private Double pZ;

    @Column
    private Double vX0;

    @Column
    private Double vY0;

    @Column
    private Double vZ0;

    @Column
    private Double x;

    @Column
    private Double y;

    @Column
    private Double x0;

    @Column
    private Double y0;

    @Column
    private Double z0;

    @Column
    private Double aX;

    @Column
    private Double breakAngle;

    @Column
    private Double breakLength;

    @Column
    private Double breakY;

    @Column
    private Double breakVertical;

    @Column
    private Double breakVerticalInduced;

    @Column
    private Double breakHorizontal;

    @Column
    private Double spinRate;

    @Column
    private Double spinDirection;

    @Column
    private Long zone;

    @Column
    private Double typeConfidence;

    @Column
    private Double plateTime;

    @Column
    private Double extension;

    @Column
    private String event;

    @Column
    private String eventType;

    @Column
    private Long awayScore;

    @Column
    private Long homeScore;

    @Column
    private Boolean isScoringPlay;

    @Column
    private Boolean isSubstitution;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Person player;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Position position;

    @EqualsAndHashCode.Include
    private Long gameId(){
        return play == null ? null : play.gameId();
    }

    @EqualsAndHashCode.Include
    private Long atBatIndex(){
        return play == null ? null : play.getAtBatIndex();
    }

    @EqualsAndHashCode.Include
    private Long playerId(){
        return player == null ? null : player.getId();
    }

    @EqualsAndHashCode.Include
    private String positionCode(){
        return position == null ? null : position.getCode();
    }

}
