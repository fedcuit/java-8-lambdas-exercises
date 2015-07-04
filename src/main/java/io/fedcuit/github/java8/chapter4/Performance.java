package io.fedcuit.github.java8.chapter4;

import io.fedcuit.github.java8.domain.Artist;

import java.util.function.Function;
import java.util.stream.Stream;

public interface Performance {
    public String getName();

    public Stream<Artist> getMusicians();

    public default Stream<String> getAllMusicians() {
        return getMusicians().flatMap(toStream()).map(Artist::getName);
    }

    default Function<Artist, Stream<? extends Artist>> toStream() {
        return artist -> artist.getMembers().isEmpty() ? Stream.of(artist) : artist.getMembers().stream();
    }
}
