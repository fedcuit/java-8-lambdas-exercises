package io.fedcuit.github.java8.chapter5;

import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.stream.Collector.Characteristics.UNORDERED;

public class MyStringJoiner implements Collector<String, StringCombiner, String> {
    private final String delim;
    private final String prefix;
    private final String suffix;

    public MyStringJoiner(String delim, String prefix, String suffix) {
        this.delim = delim;
        this.prefix = prefix;
        this.suffix = suffix;
    }

    @Override
    public Supplier<StringCombiner> supplier() {
        return () -> new StringCombiner(delim, prefix, suffix);
    }

    @Override
    public BiConsumer<StringCombiner, String> accumulator() {
        return StringCombiner::add;
    }

    @Override
    public BinaryOperator<StringCombiner> combiner() {
        return StringCombiner::merge;
    }

    @Override
    public Function<StringCombiner, String> finisher() {
        return StringCombiner::build;
    }

    @Override
    public Set<Characteristics> characteristics() {
        // The characteristics method is also very important, compiler will do some optimization base on the `Characteristics` of a collector,
        // so you need to set your collector's characteristics to the proper value, otherwise a runtime exception will be thrown.
        HashSet<Characteristics> characteristicses = new HashSet<>();
        characteristicses.add(UNORDERED);
        return characteristicses;
    }
}
