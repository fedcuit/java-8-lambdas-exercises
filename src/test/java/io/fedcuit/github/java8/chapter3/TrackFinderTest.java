package io.fedcuit.github.java8.chapter3;

import io.fedcuit.github.java8.domain.Album;
import io.fedcuit.github.java8.domain.Track;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.fest.assertions.Assertions.assertThat;

public class TrackFinderTest {

    private List<Album> albums;
    private TrackFinder trackFinder;

    @Before
    public void before() {
        Album album = new Album(asList(new Track(62, "don't go"), new Track(30, "ending")));
        Album album1 = new Album(asList(new Track(40, "my sunshine"), new Track(82, "super start")));
        albums = asList(album1, album);

        trackFinder = new TrackFinder();
    }

    @Test
    public void shouldFindOutTracksLongerThanOneMinute() {
        Set<String> expectedNames = new HashSet<>(asList("don't go", "super start"));
        assertThat(trackFinder.findLongTracks(albums).map(Track::getName).collect(Collectors.toSet())).isEqualTo(expectedNames);
    }
}