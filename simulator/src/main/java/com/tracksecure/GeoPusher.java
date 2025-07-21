package com.tracksecure;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class GeoPusher {

    private final String endpoint;

    public GeoPusher(String endpoint) {
        this.endpoint = endpoint;
    }

    public void push(GeoCoordinate coordinate) {
        // Aqui poderia ser substituído por uma chamada HTTP, MQTT ou WebSocket
        System.out.println("Enviando coordenada: " + coordinate);
    }


    public void pushToRemoteServer(GeoCoordinate coordinate) {
        try {
            URL url = new URL(endpoint);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            String json = "{\"lat\": %.6f, \"lon\": %.6f}".formatted(
                    coordinate.latitude(), coordinate.longitude()
            );

            try (OutputStream os = conn.getOutputStream()) {
                os.write(json.getBytes(StandardCharsets.UTF_8));
            }

            int responseCode = conn.getResponseCode();
            System.out.println("Push status: " + responseCode);
            conn.disconnect();

        } catch (Exception e) {
            System.err.println("Erro ao enviar coordenada: " + e.getMessage());
        }
    }
}


