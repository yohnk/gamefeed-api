package com.nxx5.baseball.hibernate;

import jakarta.persistence.Column;
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
@Entity(name = "division")
public class Division {

    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private Long season;

    @Column
    private String nameShort;

    @Column
    private String link;

    @Column
    private String abbreviation;

    @ManyToOne
    private League league;

    @ManyToOne
    private Sport sport;

    @Column
    private Boolean hasWildcard;

    @Column
    private Long sortOrder;

    @Column
    private Long numPlayoffTeams;

    @Column
    private Boolean active;
}
