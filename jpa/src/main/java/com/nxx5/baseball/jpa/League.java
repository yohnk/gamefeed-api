package com.nxx5.baseball.jpa;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity(name = "league")
public class League {

    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private String link;

    @Column
    private String abbreviation;

    @Column
    private String nameShort;

    @Column
    private String seasonState;

    @Column
    private Boolean hasWildCard;

    @Column
    private Boolean hasSplitSeason;

    @Column
    private Long numGames;

    @Column
    private Boolean hasPlayoffPoints;

    @Column
    private Long numTeams;

    @Column
    private Long numWildcardTeams;

    @Column
    private Long season;

    @Column
    private String orgCode;

    @Column
    private Boolean conferencesInUse;

    @Column
    private Boolean divisionsInUse;

    @ManyToOne
    private Sport sport;

    @Column
    private Long sortOrder;

    @Column
    private Boolean active;

    @OneToMany
    private Set<SeasonDateInfo> seasonDateInfo;

}
