package com.tracksecure;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) throws InterruptedException {
        // Posição inicial (ex: Avenida Paulista, SP)
        GeoCoordinate start = new GeoCoordinate(-23.561414, -46.655881);

        GeoWalker walker = new GeoWalker(start);
        GeoPusher pusher = new GeoPusher("http://localhost:8085/geo");

        for (int i = 0; i < 30; i++) {
            GeoCoordinate current = walker.walk();
            pusher.pushToRemoteServer(current);
            Thread.sleep(3000); // Espera 1 segundo entre os passos
        }
    }
}
