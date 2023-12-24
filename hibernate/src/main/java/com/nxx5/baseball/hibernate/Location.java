package com.nxx5.baseball.hibernate;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "venue_location")
public class Location {

    @Id
    @OneToOne
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

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
        if(Objects.nonNull(this.venue) && Objects.isNull(this.venue.getLocation())){
            this.venue.setLocation(this);
        }
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStateAbbrev() {
        return stateAbbrev;
    }

    public void setStateAbbrev(String stateAbbrev) {
        this.stateAbbrev = stateAbbrev;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getAzimuthAngle() {
        return azimuthAngle;
    }

    public void setAzimuthAngle(Double azimuthAngle) {
        this.azimuthAngle = azimuthAngle;
    }

    public Double getElevation() {
        return elevation;
    }

    public void setElevation(Double elevation) {
        this.elevation = elevation;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(venue.getId(), location.venue.getId()) && Objects.equals(address1, location.address1) && Objects.equals(city, location.city) && Objects.equals(state, location.state) && Objects.equals(stateAbbrev, location.stateAbbrev) && Objects.equals(postalCode, location.postalCode) && Objects.equals(latitude, location.latitude) && Objects.equals(longitude, location.longitude) && Objects.equals(azimuthAngle, location.azimuthAngle) && Objects.equals(elevation, location.elevation) && Objects.equals(country, location.country) && Objects.equals(phone, location.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(venue.getId(), address1, city, state, stateAbbrev, postalCode, latitude, longitude, azimuthAngle, elevation, country, phone);
    }
}
