package io.fedcuit.github.java8.chapter3;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.fest.assertions.Assertions.assertThat;

public class StreamLiteTest {

    @Test
    public void shouldAbleToMap() {
        List<String> list = StreamLite.map(asList("a", "b", "c").stream(), String::toUpperCase);

        assertThat(list).isEqualTo(asList("A", "B", "C"));
    }

    @Test
    public void shouldAbleToFilter() {
        List<Integer> largerThan10 = StreamLite.filter(asList(12, 22, 8, -1).stream(), x -> x > 10);

        assertThat(largerThan10).isEqualTo(asList(12, 22));
    }
}