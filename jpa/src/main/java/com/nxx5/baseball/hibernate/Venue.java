package com.nxx5.baseball.hibernate;

import jakarta.persistence.*;
import lombok.*;
import java.util.Objects;

@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @EqualsAndHashCode
@Entity(name = "venue")
public class Venue {

    @NonNull
    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private String link;

    @Column
    private Boolean active;

    @Column
    private Long season;

    @OneToOne(cascade = CascadeType.MERGE)
    private Location location;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Timezone timezone;

    @OneToOne(cascade = CascadeType.MERGE)
    private FieldInfo fieldInfo;

    public void setLocation(Location location) {
        this.location = location;
        if(Objects.nonNull(this.location) && Objects.isNull(this.location.getVenue())){
            this.location.setVenue(this);
        }
    }

    public void setFieldInfo(FieldInfo fieldInfo) {
        this.fieldInfo = fieldInfo;
        if(Objects.nonNull(this.fieldInfo) && Objects.isNull(this.fieldInfo.getVenue())){
            this.fieldInfo.setVenue(this);
        }
    }
}
