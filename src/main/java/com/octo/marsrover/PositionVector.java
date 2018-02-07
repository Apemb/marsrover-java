package com.octo.marsrover;

import java.util.Objects;

public class PositionVector {

    private int longitude;
    private final int latitude;
    private final Direction bearing;

    public PositionVector(int longitude, int latitude, Direction bearing) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.bearing = bearing;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public Direction getBearing() {
        return bearing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositionVector that = (PositionVector) o;
        return longitude == that.longitude &&
                latitude == that.latitude &&
                bearing == that.bearing;
    }

    @Override
    public int hashCode() {
        return Objects.hash(longitude, latitude, bearing);
    }

    @Override
    public String toString() {
        return "PositionVector{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                ", bearing=" + bearing +
                '}';
    }
}
