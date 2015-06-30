package io.fedcuit.github.java8.domain;

public class Track {
    private final int length; // in seconds
    private final String name;

    public Track(int length, String name) {
        this.length = length;
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public String getName() {
        return name;
    }
}
