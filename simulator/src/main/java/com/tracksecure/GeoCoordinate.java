package com.tracksecure;

public record GeoCoordinate(double latitude, double longitude) {

    public GeoCoordinate move(double deltaLat, double deltaLon) {
        return new GeoCoordinate(latitude + deltaLat, longitude + deltaLon);
    }

    @Override
    public String toString() {
        return "Lat: %.6f, Lon: %.6f".formatted(latitude, longitude);
    }
}
