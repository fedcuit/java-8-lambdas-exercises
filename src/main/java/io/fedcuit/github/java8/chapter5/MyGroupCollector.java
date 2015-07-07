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

public class MyGroupCollector<T, K> implements Collector<T, MyGrouper<T, K>, Map<K, List<T>>> {

    private final Function<T, K> classifier;

    public MyGroupCollector(Function<T, K> classifier) {
        this.classifier = classifier;
    }

    @Override
    public Supplier<MyGrouper<T, K>> supplier() {
        return () -> new MyGrouper<>(classifier);
    }

    @Override
    public BiConsumer<MyGrouper<T, K>, T> accumulator() {
        return MyGrouper::add;
    }

    @Override
    public BinaryOperator<MyGrouper<T, K>> combiner() {
        return MyGrouper::merge;
    }

    @Override
    public Function<MyGrouper<T, K>, Map<K, List<T>>> finisher() {
        return MyGrouper::getMap;
    }

    @Override
    public Set<Characteristics> characteristics() {
        HashSet<Characteristics> characteristicses = new HashSet<>();
        characteristicses.add(Characteristics.UNORDERED);
        return characteristicses;
    }
}
