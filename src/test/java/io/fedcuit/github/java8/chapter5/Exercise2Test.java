package io.fedcuit.github.java8.chapter5;

import org.junit.Before;
import org.junit.Test;

import java.util.Optional;
import java.util.stream.Stream;

import static io.fedcuit.github.java8.chapter5.Exercise2.*;
import static org.fest.assertions.Assertions.assertThat;
import static org.fest.assertions.MapAssert.entry;

public class Exercise2Test {

    private Stream<String> names;

    @Before
    public void setUp() throws Exception {
        names = Stream.of("John Lennon", "Paul McCartney", "George Harrison", "Ringo Starr", "Pete Best", "Stuart Sutcliffe");
    }

    @Test
    public void shouldReturnLongestArtistName() throws Exception {
        Optional<String> longestArtistName = longestArtistName(names);
        assertThat(longestArtistName.isPresent()).isTrue();
        assertThat(longestArtistName.get()).isEqualTo("Stuart Sutcliffe");
    }

    @Test
    public void shouldReturnLongestArtistNameByReduce() throws Exception {
        Optional<String> longestArtistName = longestArtistNameByReduce(names);
        assertThat(longestArtistName.isPresent()).isTrue();
        assertThat(longestArtistName.get()).isEqualTo("Stuart Sutcliffe");
    }

    @Test
    public void shouldCountWordFrequency() throws Exception {
        Stream<String> names = Stream.of("John", "Paul", "George", "John",
                "Paul", "John");
        assertThat(countFrequency(names))
                .includes(entry("John", 3L))
                .includes(entry("Paul", 2L))
                .includes(entry("George", 1L));
    }
}