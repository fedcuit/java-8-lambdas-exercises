package io.fedcuit.github.java8.chapter5;

import java.util.Optional;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.maxBy;

public class Exercise2 {
    public static Optional<String> longestArtistName(Stream<String> names) {
//        return names.max(Comparator.comparing(String::length));
        return names.collect(maxBy(comparing(String::length)));
    }

    public static Optional<String> longestArtistNameByReduce(Stream<String> names) {
        return names.reduce((acc, x) -> x.length() > acc.length() ? x : acc);
    }
}
