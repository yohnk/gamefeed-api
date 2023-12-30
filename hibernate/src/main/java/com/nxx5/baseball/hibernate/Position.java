package com.nxx5.baseball.hibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity(name = "position")
public class Position {

    @Id
    private String code;

    @Column
    private String name;

    @Column
    private String type;

    @Column
    private String abbreviation;
}
