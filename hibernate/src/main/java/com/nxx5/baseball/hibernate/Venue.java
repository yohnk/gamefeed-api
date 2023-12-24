package com.nxx5.baseball.hibernate;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.Objects;

@Entity(name = "venue")
public class Venue {

    public Venue(Long id) {
        this.id = id;
    }

    public Venue() {
    }

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

    @OneToOne
    @Cascade(CascadeType.MERGE)
    private Location location;

    @ManyToOne
    @Cascade(CascadeType.MERGE)
    private Timezone timezone;

    @OneToOne
    @Cascade(CascadeType.MERGE)
    private FieldInfo fieldInfo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Long getSeason() {
        return season;
    }

    public void setSeason(Long season) {
        this.season = season;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
        if(Objects.nonNull(this.location) && Objects.isNull(this.location.getVenue())){
            this.location.setVenue(this);
        }
    }

    public Timezone getTimezone() {
        return timezone;
    }

    public void setTimezone(Timezone timezone) {
        this.timezone = timezone;
    }

    public FieldInfo getFieldInfo() {
        return fieldInfo;
    }

    public void setFieldInfo(FieldInfo fieldInfo) {
        this.fieldInfo = fieldInfo;
        if(Objects.nonNull(this.fieldInfo) && Objects.isNull(this.fieldInfo.getVenue())){
            this.fieldInfo.setVenue(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venue venue = (Venue) o;
        return Objects.equals(id, venue.id) && Objects.equals(name, venue.name) && Objects.equals(link, venue.link) && Objects.equals(active, venue.active) && Objects.equals(season, venue.season) && Objects.equals(location, venue.location) && Objects.equals(timezone, venue.timezone) && Objects.equals(fieldInfo, venue.fieldInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, link, active, season, location, timezone, fieldInfo);
    }
}
