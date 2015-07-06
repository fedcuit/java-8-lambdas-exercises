package io.fedcuit.github.java8.chapter5;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class MethodReferenceExercise {
    public static List<String> toUpperCase(List<String> strings) {
        return strings.stream().map(String::toUpperCase).collect(toList());
    }

    public static int countLetters(List<String> strings) {
        return strings.stream().reduce(0, (acc, x) -> acc + x.length(), (left, right) -> left + right);
    }

    public static <T> List<T> concatenate(List<List<T>> lists) {
        return lists.stream().flatMap(Collection::stream).collect(toList());
    }
}
