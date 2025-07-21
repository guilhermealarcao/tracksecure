package com.tracksecure;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        try {
            MockGeoServer.start(8085);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}