package com.nxx5.baseball.hibernate;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "field_info")
public class FieldInfo {

    @Id
    @OneToOne
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

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
        if(Objects.nonNull(this.venue) && Objects.isNull(this.venue.getFieldInfo())){
            this.venue.setFieldInfo(this);
        }
    }

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    public String getTurfType() {
        return turfType;
    }

    public void setTurfType(String turfType) {
        this.turfType = turfType;
    }

    public String getRoofType() {
        return roofType;
    }

    public void setRoofType(String roofType) {
        this.roofType = roofType;
    }

    public Long getLeftLine() {
        return leftLine;
    }

    public void setLeftLine(Long leftLine) {
        this.leftLine = leftLine;
    }

    public Long getLeftField() {
        return leftField;
    }

    public void setLeftField(Long left) {
        this.leftField = left;
    }

    public Long getLeftCenter() {
        return leftCenter;
    }

    public void setLeftCenter(Long leftCenter) {
        this.leftCenter = leftCenter;
    }

    public Long getCenterField() {
        return centerField;
    }

    public void setCenterField(Long center) {
        this.centerField = center;
    }

    public Long getRightCenter() {
        return rightCenter;
    }

    public void setRightCenter(Long rightCenter) {
        this.rightCenter = rightCenter;
    }

    public Long getRightField() {
        return rightField;
    }

    public void setRightField(Long right) {
        this.rightField = right;
    }

    public Long getRightLine() {
        return rightLine;
    }

    public void setRightLine(Long rightLine) {
        this.rightLine = rightLine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FieldInfo fieldInfo = (FieldInfo) o;
        return Objects.equals(venue.getId(), fieldInfo.venue.getId()) && Objects.equals(capacity, fieldInfo.capacity) && Objects.equals(turfType, fieldInfo.turfType) && Objects.equals(roofType, fieldInfo.roofType) && Objects.equals(leftLine, fieldInfo.leftLine) && Objects.equals(leftField, fieldInfo.leftField) && Objects.equals(leftCenter, fieldInfo.leftCenter) && Objects.equals(centerField, fieldInfo.centerField) && Objects.equals(rightCenter, fieldInfo.rightCenter) && Objects.equals(rightField, fieldInfo.rightField) && Objects.equals(rightLine, fieldInfo.rightLine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(venue.getId(), capacity, turfType, roofType, leftLine, leftField, leftCenter, centerField, rightCenter, rightField, rightLine);
    }
}
