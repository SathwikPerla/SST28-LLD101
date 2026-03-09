package com.example.map;

/*
 * REFACTORING FOR FLYWEIGHT
 *
 * WHAT WAS WRONG BEFORE:
 * Each MapMarker created a new MarkerStyle object inside its constructor.
 * This caused massive duplication when thousands of markers shared the
 * same style.
 *
 * DESIGN AFTER REFACTOR:
 *
 * INTRINSIC STATE (shared)
 *     MarkerStyle style
 *
 * EXTRINSIC STATE (unique per marker)
 *     latitude
 *     longitude
 *     label
 *
 * The style is now provided by MarkerStyleFactory and shared
 * across markers with identical configurations.
 */

public class MapMarker {

    // EXTRINSIC STATE (unique for each marker)
    private final double lat;
    private final double lng;
    private final String label;

    // INTRINSIC STATE (shared Flyweight)
    private final MarkerStyle style;

    // Constructor now receives shared MarkerStyle instead of creating it
    public MapMarker(double lat, double lng, String label, MarkerStyle style) {
        this.lat = lat;
        this.lng = lng;
        this.label = label;
        this.style = style;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    public String getLabel() {
        return label;
    }

    public MarkerStyle getStyle() {
        return style;
    }
}