package com.nxx5.baseball.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity(name = "sport")
public class Sport {

    @Id
    private Long id;

    @Column
    private String code;

    @Column
    private String link;

    @Column
    private String name;

    @Column
    private String abbreviation;

    @Column
    private Long sortOrder;

    @Column
    private Boolean activeStatus;

}
