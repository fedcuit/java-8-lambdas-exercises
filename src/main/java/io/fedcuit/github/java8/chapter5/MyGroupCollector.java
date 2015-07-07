package io.fedcuit.github.java8.chapter5;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class MyGroupCollector<T> implements Collector<T, MyGrouper<T>, Map<T, List<T>>> {

    private final Function<T, T> classifier;

    public MyGroupCollector(Function<T, T> classifier) {
        this.classifier = classifier;
    }

    @Override
    public Supplier<MyGrouper<T>> supplier() {
        return () -> new MyGrouper<>(classifier);
    }

    @Override
    public BiConsumer<MyGrouper<T>, T> accumulator() {
        return MyGrouper::add;
    }

    @Override
    public BinaryOperator<MyGrouper<T>> combiner() {
        return MyGrouper::merge;
    }

    @Override
    public Function<MyGrouper<T>, Map<T, List<T>>> finisher() {
        return MyGrouper::getMap;
    }

    @Override
    public Set<Characteristics> characteristics() {
        HashSet<Characteristics> characteristicses = new HashSet<>();
        characteristicses.add(Characteristics.UNORDERED);
        return characteristicses;
    }
}
