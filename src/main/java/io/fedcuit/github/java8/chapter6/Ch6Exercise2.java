package io.fedcuit.github.java8.chapter6;

import java.util.List;

public class Ch6Exercise2 {
    public static int multiplyThrough(List<Integer> linkedListOfNumbers) {
        return 5 * linkedListOfNumbers.stream().parallel()
                .reduce(1, (acc, x) -> x * acc);
    }

    public static long slowSumOfSquares(List<Long> linkedListOfNumbers) {
        return linkedListOfNumbers.stream().map(x -> x * x).reduce(0L, (acc, x) -> acc + x);
    }
}
