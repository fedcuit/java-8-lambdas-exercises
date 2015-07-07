package io.fedcuit.github.java8.chapter5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyGrouper {
    private final Map<String, List<String>> map;

    public MyGrouper() {
        map = new HashMap<>();
    }

    public MyGrouper add(String x) {
        String classifier = x.substring(0, 4);
        List<String> group = map.computeIfAbsent(classifier, __ -> new ArrayList<>());
        group.add(x);
        return this;
    }

    public MyGrouper merge(MyGrouper other) {
        map.putAll(other.getMap());
        return this;
    }

    public Map<String, List<String>> getMap() {
        return map;
    }
}
