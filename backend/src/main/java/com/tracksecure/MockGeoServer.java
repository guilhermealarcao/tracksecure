package com.tracksecure;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class MockGeoServer {

    public static void start(int port) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/geo", new GeoHandler());
        server.setExecutor(null);
        server.start();
        System.out.println("Servidor escutando em http://localhost:" + port + "/geo");
    }

}
