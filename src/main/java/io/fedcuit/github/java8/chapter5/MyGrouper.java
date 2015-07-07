package io.fedcuit.github.java8.chapter5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class MyGrouper<T> {
    private final Map<T, List<T>> map;
    private final Function<T, T> classifier;

    public MyGrouper(Function<T, T> classifier) {
        this.classifier = classifier;
        map = new HashMap<>();
    }

    public MyGrouper add(T x) {
        List<T> group = map.computeIfAbsent(classifier.apply(x), __ -> new ArrayList<>());
        group.add(x);
        return this;
    }

    public MyGrouper merge(MyGrouper other) {
        map.putAll(other.getMap());
        return this;
    }

    public Map<T, List<T>> getMap() {
        return map;
    }
}
