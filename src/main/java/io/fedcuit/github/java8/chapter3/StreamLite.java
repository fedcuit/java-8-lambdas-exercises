package io.fedcuit.github.java8.chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamLite {
    public static <I, O> List<O> map(Stream<I> stream, Function<I, O> mapper) {
        return stream.reduce(new ArrayList<>(), (acc, x) -> {
            List<O> newAcc = new ArrayList<>(acc);
            newAcc.add(mapper.apply(x));
            return newAcc;
        }, (List<O> left, List<O> right) -> {
            List<O> newLeft = new ArrayList<>(left);
            newLeft.addAll(right);
            return newLeft;
        });
    }

    public static <I> List<I> filter(Stream<I> stream, Predicate<I> predicate) {
        return stream.reduce(new ArrayList<>(), (acc, x) -> {
            List<I> newAcc = new ArrayList<>(acc);
            if (predicate.test(x)) {
                newAcc.add(x);
            }
            return newAcc;
        }, (List<I> left, List<I> right) -> {
            List<I> newLeft = new ArrayList<I>(left);
            newLeft.addAll(right);
            return newLeft;
        });
    }
}
