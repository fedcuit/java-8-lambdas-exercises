package io.fedcuit.github.java8.chapter3;

import io.fedcuit.github.java8.TestFixture;
import io.fedcuit.github.java8.domain.Album;
import io.fedcuit.github.java8.domain.Artist;
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
        List<Artist> artists = TestFixture.getArtists();

        assertThat(exercises.collectArtistInfos(artists)).isEqualTo(asList("Jay China", "Jay2 Taiwan", "Jay3 HongKong"));
    }

    @Test
    public void shouldFindAlbumThatHasThreeTracksAtMost() {
        List<Album> albums = TestFixture.getAlbums();

        assertThat(exercises.albumWhichMaximum3Tracks(albums)).isEqualTo(asList(albums.get(0), albums.get(1)));
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

    @Test
    public void shouldReturnEmptyForEmptyStringList() {
        Optional<String> word = exercises.withMostLowerCase(asList());

        assertThat(word.isPresent()).isFalse();
    }
}