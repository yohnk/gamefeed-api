package com.nxx5.baseball.hibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

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
