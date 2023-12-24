package com.nxx5.baseball.hibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity(name = "timezone")
public class Timezone {

    @Id
    private String id;

    @Column
    private Long tzOffset;

    @Column
    private Long offsetAtGameTime;

    @Column
    private String tz;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getTzOffset() {
        return tzOffset;
    }

    public void setTzOffset(Long offset) {
        this.tzOffset = offset;
    }

    public Long getOffsetAtGameTime() {
        return offsetAtGameTime;
    }

    public void setOffsetAtGameTime(Long offsetAtGameTime) {
        this.offsetAtGameTime = offsetAtGameTime;
    }

    public String getTz() {
        return tz;
    }

    public void setTz(String tz) {
        this.tz = tz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Timezone timezone = (Timezone) o;
        return Objects.equals(id, timezone.id) && Objects.equals(tzOffset, timezone.tzOffset) && Objects.equals(offsetAtGameTime, timezone.offsetAtGameTime) && Objects.equals(tz, timezone.tz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tzOffset, offsetAtGameTime, tz);
    }
}
