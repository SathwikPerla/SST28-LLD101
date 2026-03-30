package com.example.map;

import java.util.List;

/**
 * Entry point of the application.
 * Responsible for bootstrapping the system and running the demo.
 */
public class App {

    public static void main(String[] args) {
        int n = 30_000;

        MapDataSource ds = new MapDataSource();
        List<MapMarker> markers = ds.loadMarkers(n);

        new MapRenderer().render(markers);

        System.out.println();
        System.out.println("Run QuickCheck to verify Flyweight sharing:");
        System.out.println("  java com.example.map.QuickCheck");
    }
}
