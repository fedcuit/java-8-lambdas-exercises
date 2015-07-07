package io.fedcuit.github.java8.chapter6;

import java.util.List;

public class Ch6Exercise2 {
    public static int multiplyThrough(List<Integer> linkedListOfNumbers) {
        Integer product = linkedListOfNumbers.stream().parallel()
                .reduce(1, (acc, x) -> x * acc);
        return product * 5;
    }

    public static long slowSumOfSquares(List<Long> linkedListOfNumbers) {
        return linkedListOfNumbers.stream().map(x -> x * x).reduce(0L, (acc, x) -> acc + x);
    }
}
