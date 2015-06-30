package io.fedcuit.github.java8.domain;

import java.util.List;
import java.util.stream.Stream;

public class Album {
    private final List<Track> trackList;

    public Album(List<Track> trackList) {
        this.trackList = trackList;
    }

    public Stream<Track> getTrackList() {
        return trackList.stream();
    }
}
