package io.fedcuit.github.java8.chapter3;

import io.fedcuit.github.java8.domain.Album;
import io.fedcuit.github.java8.domain.Track;

import java.util.List;
import java.util.stream.Stream;

public class TrackFinder {
    public Stream<Track> findLongTracks(List<Album> albumList) {
        return albumList.stream()
                .flatMap(Album::getTrackList)
                .filter(track -> track.getLength() > 60);
    }
}
