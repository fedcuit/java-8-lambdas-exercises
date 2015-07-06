package io.fedcuit.github.java8.chapter5;

import org.junit.Before;
import org.junit.Test;

import java.util.Optional;
import java.util.stream.Stream;

import static io.fedcuit.github.java8.chapter5.Exercise2.longestArtistName;
import static io.fedcuit.github.java8.chapter5.Exercise2.longestArtistNameByReduce;
import static org.fest.assertions.Assertions.assertThat;

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
}