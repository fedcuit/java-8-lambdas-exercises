package io.fedcuit.github.java8.chapter3;

import io.fedcuit.github.java8.domain.Album;
import io.fedcuit.github.java8.domain.Artist;
import io.fedcuit.github.java8.domain.Track;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;
import static org.fest.assertions.Assertions.assertThat;

public class ExercisesTest {

    private Exercises exercises;

    @Before
    public void setUp() throws Exception {
        exercises = new Exercises();
    }

    @Test
    public void shouldSumTheNumbersUp() {
        assertThat(exercises.addUp(asList(1, 2, 3, 4, 5).stream())).isEqualTo(15);
    }

    @Test
    public void shouldCollectArtistNamesAndNationalities() {
        Artist artist = new Artist("Jay", "China", asList());
        Artist artist1 = new Artist("Jay2", "Taiwan", asList());
        Artist artist2 = new Artist("Jay3", "HongKong", asList());

        List<Artist> artists = asList(artist, artist1, artist2);

        assertThat(exercises.collectArtistInfos(artists)).isEqualTo(asList("Jay China", "Jay2 Taiwan", "Jay3 HongKong"));
    }

    @Test
    public void shouldFindAlbumThatHasThreeTracksAtMost() {
        Album album = new Album(asList(new Track(62, "don't go"), new Track(30, "ending")));
        Album album1 = new Album(asList(new Track(40, "my sunshine"), new Track(82, "super start"), new Track(22, "because of you")));
        Album album2 = new Album(asList(new Track(40, "my sunshine"), new Track(82, "super start"), new Track(41, "safe and sound"), new Track(22, "yesterday once more")));
        List<Album> albums = asList(album, album1, album2);

        assertThat(exercises.albumWhichMaximum3Tracks(albums)).isEqualTo(asList(album, album1));
    }

    @Test
    public void shouldAbleToCountLowerCaseInAString() {
        assertThat(exercises.countLowercase("ab391@AJWLLJFQPQj82")).isEqualTo(3);
    }

    @Test
    public void shouldFindTheOneWithMostLowerCaseLetters() {
        List<String> words = asList("After I published my article on using Celery with Flask several readers asked how this integration".split(" "));

        Optional<String> wordWithMostLowercase = exercises.withMostLowerCase(words);
        assertThat(wordWithMostLowercase.isPresent()).isTrue();
        assertThat(wordWithMostLowercase.get()).isEqualTo("integration");
    }
}