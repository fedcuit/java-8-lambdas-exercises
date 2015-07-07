package io.fedcuit.github.java8.chapter5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class MyGrouper<T, K> {
    private final Map<K, List<T>> map;
    private final Function<T, K> classifier;

    public MyGrouper(Function<T, K> classifier) {
        this.classifier = classifier;
        map = new HashMap<>();
    }

    public MyGrouper<T, K> add(T x) {
        List<T> group = map.computeIfAbsent(classifier.apply(x), __ -> new ArrayList<>());
        group.add(x);
        return this;
    }

    public MyGrouper<T, K> merge(MyGrouper other) {
        map.putAll(other.getMap());
        return this;
    }

    public Map<K, List<T>> getMap() {
        return map;
    }
}
