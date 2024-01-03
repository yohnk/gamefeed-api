package com.nxx5.baseball.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

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

    @EqualsAndHashCode.Include
    public Long getLeagueId(){
        return league == null ? null : league.getId();
    }

    @EqualsAndHashCode.Include
    public Long getSpringLeagueId(){
        return springLeague == null ? null : springLeague.getId();
    }

    @EqualsAndHashCode.Include
    public Long getVenueId(){
        return venue == null ? null : venue.getId();
    }

    @EqualsAndHashCode.Include
    public Long getSportId(){
        return sport == null ? null : sport.getId();
    }
}
