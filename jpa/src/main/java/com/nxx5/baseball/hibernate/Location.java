package com.nxx5.baseball.hibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.util.Objects;

@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @EqualsAndHashCode
@Entity(name = "venue_location")
public class Location {

    @Id
    @OneToOne
    @NonNull
    @EqualsAndHashCode.Exclude
    private Venue venue;

    @Column
    private String address1;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private String stateAbbrev;

    @Column
    private String postalCode;

    @Column
    private Double latitude;

    @Column
    private Double longitude;

    @Column
    private Double azimuthAngle;

    @Column
    private Double elevation;

    @Column
    private String country;

    @Column
    private String phone;

    @EqualsAndHashCode.Include
    private Long venueId(){
        return venue == null ? null : venue.getId();
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
        if(Objects.nonNull(this.venue) && Objects.isNull(this.venue.getLocation())){
            this.venue.setLocation(this);
        }
    }
}
