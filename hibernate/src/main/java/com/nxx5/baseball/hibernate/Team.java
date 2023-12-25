package com.nxx5.baseball.hibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @EqualsAndHashCode
@Entity(name = "team")
public class Team {

    @NonNull
    @Id
    private Long id;

}
