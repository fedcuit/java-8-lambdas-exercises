package io.fedcuit.github.java8.chapter4;

import io.fedcuit.github.java8.TestFixture;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class ArtistsTest {

    private Artists artists;

    @Before
    public void setUp() throws Exception {
        artists = new Artists(TestFixture.getArtists());
    }

    @Test
    public void shouldReturnArtistByIndex() throws Exception {
        assertThat(artists.getArtist(2).isPresent()).isTrue();
    }

    @Test
    public void shouldReturnEmptyGivenInvalidIndex() throws Exception {
        assertThat(artists.getArtist(4).isPresent()).isFalse();
    }

    @Test
    public void shouldReturnArtistNameByIndex() throws Exception {
        assertThat(artists.getArtist(2).get().getName()).isEqualTo("Jay3");
    }

    @Test
    public void shouldReturnUnknownGivenInvalidIndex() throws Exception {
        assertThat(artists.getArtistName(4)).isEqualTo("unknown");
    }
}