package com.nxx5.baseball.hibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venue venue = (Venue) o;
        return Objects.equals(id, venue.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
