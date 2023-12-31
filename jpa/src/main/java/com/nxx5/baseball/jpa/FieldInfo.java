package com.nxx5.baseball.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.util.Objects;

@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @EqualsAndHashCode
@Entity(name = "field_info")
public class FieldInfo {

    @Id
    @OneToOne
    @NonNull
    @EqualsAndHashCode.Exclude
    private Venue venue;

    @Column
    private Long capacity;

    @Column
    private String turfType;

    @Column
    private String roofType;

    @Column
    private Long leftLine;

    @Column
    private Long leftField;

    @Column
    private Long leftCenter;

    @Column
    private Long centerField;

    @Column
    private Long rightCenter;

    @Column
    private Long rightField;

    @Column
    private Long rightLine;

    @EqualsAndHashCode.Include
    private Long venueId(){
        return venue == null ? null : venue.getId();
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
        if(Objects.nonNull(this.venue) && Objects.isNull(this.venue.getFieldInfo())){
            this.venue.setFieldInfo(this);
        }
    }
}
