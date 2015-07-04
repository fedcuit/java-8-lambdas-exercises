package io.fedcuit.github.java8.chapter4;

import io.fedcuit.github.java8.domain.Artist;
import org.junit.Test;

import java.util.stream.Stream;

import static io.fedcuit.github.java8.TestFixture.getArtists;
import static io.fedcuit.github.java8.TestFixture.getArtistsWithGroup;
import static java.util.stream.Collectors.joining;
import static org.fest.assertions.Assertions.assertThat;

public class PerformanceTest {
    class DefaultPerformance implements Performance {

        @Override
        public String getName() {
            return "The one";
        }

        @Override
        public Stream<Artist> getMusicians() {
            return getArtists().stream();
        }
    }

    class GroupPerformance extends DefaultPerformance {
        @Override
        public Stream<Artist> getMusicians() {
            return getArtistsWithGroup().stream();
        }
    }

    @Test
    public void shouldGetAllMusicians() throws Exception {
        DefaultPerformance performance = new DefaultPerformance();

        assertThat(performance.getAllMusicians().collect(joining(", ", "[", "]"))).isEqualTo("[Jay, Jay2, Jay3]");
    }

    @Test
    public void shouldGetAllMusiciansEvenHasGroup() throws Exception {
        GroupPerformance performance = new GroupPerformance();
        assertThat(performance.getAllMusicians().collect(joining(", ", "[", "]"))).isEqualTo("[Jay, Jay2, Little Jay, Big Jay]");
    }
}