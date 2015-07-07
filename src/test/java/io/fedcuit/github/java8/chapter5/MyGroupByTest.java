package io.fedcuit.github.java8.chapter5;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.fest.assertions.Assertions.assertThat;

public class MyGroupByTest {

    private Stream<String> companies;

    @Before
    public void setUp() throws Exception {
        companies = Stream.of("Lvl1 Google", "Lvl2 MS", "Lvl1 Apple", "Lvl3 Yahoo");
    }

    @Test
    public void shouldGroupDataByNativeAPI() throws Exception {
        Map<String, List<String>> companiesByLevel = companies.collect(Collectors.groupingBy(s -> s.substring(0, 4)));
        assertThat(companiesByLevel.get("Lvl1")).contains("Lvl1 Google", "Lvl1 Apple");
        assertThat(companiesByLevel.get("Lvl2")).contains("Lvl2 MS");
        assertThat(companiesByLevel.get("Lvl3")).contains("Lvl3 Yahoo");
    }

    @Test
    public void shouldGroupDataByReduce() throws Exception {
        Map<String, List<String>> companiesByLevel = companies.reduce(new HashMap<>(), (acc, x) -> {
            String classifier = x.substring(0, 4);
            List<String> group = acc.computeIfAbsent(classifier, __ -> new ArrayList<>());
            group.add(x);
            return acc;
        }, (left, right) -> {
            left.putAll(right);
            return left;
        });

        assertThat(companiesByLevel.get("Lvl1")).contains("Lvl1 Google", "Lvl1 Apple");
        assertThat(companiesByLevel.get("Lvl2")).contains("Lvl2 MS");
        assertThat(companiesByLevel.get("Lvl3")).contains("Lvl3 Yahoo");
    }

    @Test
    public void shouldGroupDataByReduceAndMethodFromAClass() throws Exception {
        MyGrouper myGrouper = companies.reduce(new MyGrouper<String, String>(x -> x.substring(0, 4)), MyGrouper::add, MyGrouper::merge);

        Map<String, List<String>> companiesByLevel = myGrouper.getMap();

        assertThat(companiesByLevel.get("Lvl1")).contains("Lvl1 Google", "Lvl1 Apple");
        assertThat(companiesByLevel.get("Lvl2")).contains("Lvl2 MS");
        assertThat(companiesByLevel.get("Lvl3")).contains("Lvl3 Yahoo");
    }

    @Test
    public void shouldGroupDataByCustomizedCollector() throws Exception {
        Map<String, List<String>> companiesByLevel = companies.collect(new MyGroupCollector<>(x -> x.substring(0, 4)));

        assertThat(companiesByLevel.get("Lvl1")).contains("Lvl1 Google", "Lvl1 Apple");
        assertThat(companiesByLevel.get("Lvl2")).contains("Lvl2 MS");
        assertThat(companiesByLevel.get("Lvl3")).contains("Lvl3 Yahoo");
    }

    @Test
    public void shouldGroupDataByCustomizedCollectorWithDifferentKeyType() throws Exception {
        Map<Integer, List<String>> companiesByLevel = companies.collect(new MyGroupCollector<>(x -> Integer.valueOf(x.substring(3, 4))));

        assertThat(companiesByLevel.get(1)).contains("Lvl1 Google", "Lvl1 Apple");
        assertThat(companiesByLevel.get(2)).contains("Lvl2 MS");
        assertThat(companiesByLevel.get(3)).contains("Lvl3 Yahoo");
    }
}