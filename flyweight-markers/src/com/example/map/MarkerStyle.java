package com.example.map;

/*
 * REFACTORING: Flyweight Pattern
 *
 * WHAT WAS WRONG BEFORE:
 * Each MapMarker created its own MarkerStyle object even if the style
 * configuration (shape, color, size, filled) was identical. This caused
 * thousands of duplicate objects in memory.
 *
 * SOLUTION:
 * MarkerStyle is extracted as a Flyweight object that represents
 * INTRINSIC STATE shared across many markers.
 *
 * DESIGN DECISION:
 * This class is immutable so that a single instance can be safely shared.
 */

public class MarkerStyle {

    // INTRINSIC STATE (shared across many markers)
    // All fields are final to guarantee immutability
    private final String shape;
    private final String color;
    private final int size;
    private final boolean filled;

    public MarkerStyle(String shape, String color, int size, boolean filled) {
        this.shape = shape;
        this.color = color;
        this.size = size;
        this.filled = filled;
    }

    public String getShape() {
        return shape;
    }

    public String getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }

    public boolean isFilled() {
        return filled;
    }

    @Override
    public String toString() {
        return shape + "|" + color + "|" + size + "|" + (filled ? "F" : "O");
    }
}