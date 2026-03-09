package com.example.map;

import java.util.HashMap;
import java.util.Map;

/*
 * FLYWEIGHT FACTORY
 *
 * RESPONSIBILITY:
 * Maintain a cache of MarkerStyle objects and return shared instances.
 *
 * WHY THIS IS NEEDED:
 * Without this factory, every marker would create its own style object.
 * The factory ensures identical styles reuse the same instance.
 *
 * KEY IDEA:
 * styleKey = shape|color|size|filled
 */

public class MarkerStyleFactory {

    // Cache storing already created flyweight objects
    private static final Map<String, MarkerStyle> CACHE = new HashMap<>();

    public static MarkerStyle get(String shape, String color, int size, boolean filled) {

        // Unique key representing a style configuration
        String key = shape + "|" + color + "|" + size + "|" + (filled ? "F" : "O");

        // Create style only if it does not already exist
        if (!CACHE.containsKey(key)) {
            CACHE.put(key, new MarkerStyle(shape, color, size, filled));
        }

        // Return shared instance
        return CACHE.get(key);
    }
}