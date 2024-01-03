package com.nxx5.baseball.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @EqualsAndHashCode
@Entity(name = "timezone")
public class Timezone {

    @NonNull
    @Id
    private String id;

    @Column
    private Long tzOffset;

    @Column
    private Long offsetAtGameTime;

    @Column
    private String tz;

}
