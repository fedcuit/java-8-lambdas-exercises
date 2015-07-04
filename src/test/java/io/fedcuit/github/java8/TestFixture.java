package io.fedcuit.github.java8;

import io.fedcuit.github.java8.domain.Album;
import io.fedcuit.github.java8.domain.Artist;
import io.fedcuit.github.java8.domain.Track;

import java.util.List;

import static java.util.Arrays.asList;

public class TestFixture {

    public static List<Artist> getArtists() {
        Artist artist = new Artist("Jay", "China", asList());
        Artist artist1 = new Artist("Jay2", "Taiwan", asList());
        Artist artist2 = new Artist("Jay3", "HongKong", asList());

        return asList(artist, artist1, artist2);
    }

    public static List<Album> getAlbums() {
        Album album = new Album(asList(new Track(62, "don't go"), new Track(30, "ending")));
        Album album1 = new Album(asList(new Track(40, "my sunshine"), new Track(82, "super start"), new Track(22, "because of you")));
        Album album2 = new Album(asList(new Track(40, "my sunshine"), new Track(82, "super start"), new Track(41, "safe and sound"), new Track(22, "yesterday once more")));
        return asList(album, album1, album2);
    }
}
