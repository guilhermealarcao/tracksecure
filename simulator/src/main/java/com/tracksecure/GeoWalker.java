package com.tracksecure;

import java.util.Random;

public class GeoWalker {

    private GeoCoordinate currentPosition;
    private final Random random = new Random();

    public GeoWalker(GeoCoordinate startPosition) {
        this.currentPosition = startPosition;
    }

    public GeoCoordinate walk() {
        // Simula um passo pequeno
        double deltaLat = (random.nextDouble() - 0.5) * 0.0001;
        double deltaLon = (random.nextDouble() - 0.5) * 0.0001;

        currentPosition = currentPosition.move(deltaLat, deltaLon);
        return currentPosition;
    }
}
