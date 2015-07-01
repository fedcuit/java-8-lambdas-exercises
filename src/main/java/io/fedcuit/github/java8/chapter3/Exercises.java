package io.fedcuit.github.java8.chapter3;

import io.fedcuit.github.java8.domain.Album;
import io.fedcuit.github.java8.domain.Artist;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class Exercises {
    public int addUp(Stream<Integer> numbers) {
        return numbers.reduce((acc, n) -> acc + n).get();
    }

    public List<Album> albumWhichMaximum3Tracks(List<Album> albums) {
        return albums.stream().filter(album -> album.getTrackList().count() <= 3).collect(toList());
    }

    // The below two methods demonstrate three ways using method reference to simplify lambda expression
    // 1. Type::instanceMethod 2. Type::new 2. Type::staticMethod

    public List<String> collectArtistInfos(List<Artist> artists) {
        return artists.stream().map(Artist::basicInfo).map(Mapper::new).map(Mapper::getValue).collect(toList());
    }

    public long countLowercase(String s) {
        return s.chars().filter(Character::isLowerCase).count();
    }

    public Optional<String> withMostLowerCase(List<String> words) {
        return words.stream().max(comparing(this::countLowercase));
    }

    class Mapper {
        private String value;
        public Mapper(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
