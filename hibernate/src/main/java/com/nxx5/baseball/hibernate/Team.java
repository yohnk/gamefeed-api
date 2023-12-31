package com.nxx5.baseball.hibernate;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @EqualsAndHashCode
@Entity(name = "team")
public class Team {

    @NonNull
    @Id
    private Long id;

    @Column
    private Boolean allStarStatus;

    @Column
    private String name;

    @Column
    private String link;

    @Column
    private Long seasons;

    @ManyToOne
    private Venue venue;

    @ManyToOne
    private Venue springVenue;

    @Column
    private String teamCode;

    @Column
    private String fileCode;

    @Column
    private String abbreviation;

    @Column
    private String teamName;

    @Column
    private String locationName;

    @Column
    private Long firstYearOfPlay;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private League league;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private League springLeague;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Division division;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Sport sport;

    @Column
    private String shortName;

    @Column
    private String franchiseName;

    @Column
    private String clubName;

    @Column
    private Boolean active;

    //TODO - Cleanup
    @EqualsAndHashCode.Include
    public Long getLeagueId(){
        if(Objects.nonNull(league)){
            return league.getId();
        }
        else {
            return null;
        }
    }

    @EqualsAndHashCode.Include
    public Long getSpringLeagueId(){
        if(Objects.nonNull(springLeague)){
            return springLeague.getId();
        }
        else {
            return null;
        }
    }

    @EqualsAndHashCode.Include
    public Long getVenueId(){
        if(Objects.nonNull(venue)){
            return venue.getId();
        }
        else {
            return null;
        }
    }

    @EqualsAndHashCode.Include
    public Long getSportId(){
        if(Objects.nonNull(sport)){
            return sport.getId();
        }
        else {
            return null;
        }
    }
}
