package io.fedcuit.github.java8.chapter3;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.fest.assertions.Assertions.assertThat;

public class StreamLiteTest {

    @Test
    public void shouldAbleToMap() {
        List<String> list = StreamLite.map(asList("a", "b", "c").stream(), (String s) -> (s.toUpperCase()));

        assertThat(list).isEqualTo(asList("A", "B", "C"));
    }
}