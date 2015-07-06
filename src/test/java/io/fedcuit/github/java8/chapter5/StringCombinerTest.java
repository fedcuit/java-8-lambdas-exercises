package io.fedcuit.github.java8.chapter5;

import org.junit.Before;
import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.fest.assertions.Assertions.assertThat;

public class StringCombinerTest {

    private Stream<String> words;

    @Before
    public void setUp() throws Exception {
        words = Stream.of("Java", "is", "cool");
    }

    @Test
    public void shouldJoinStringWithNativeAPI() throws Exception {
        assertThat(words.collect(Collectors.joining(" ", "@@", "&&"))).isEqualTo("@@Java is cool&&");
    }

    @Test
    public void shouldJoinStringWithReduce() throws Exception {
        // this
        StringBuilder sb = words.reduce(new StringBuilder(""), (acc, x) -> {
            if (acc.length() > 1) {
                acc.append(" ");
            }
            acc.append(x);
            return acc;
        }, (left, right) -> {
            left.append(right.toString());
            return left;
        });

        sb.insert(0, "[");
        sb.append("]");

        assertThat(sb.toString()).isEqualTo("[Java is cool]");
    }

    @Test
    public void shouldJoinStringWithReduceAndAClassToHoldTheFunctions() throws Exception {
//        StringCombiner stringCombiner = words.
//                reduce(new StringCombiner(" ", "[", "]"), (stringCombiner1, s) -> stringCombiner1.add(s), (stringCombiner1, other) -> stringCombiner1.merge(other));
//
        // The method reference here un unlike those we saw before (current iterated value will match method argument list), here we have two arguments: the accumulator and the iterated value.
        // Seems like only the iterated value needs to match method parameter list, and the accumulator can act as the caller.
        StringCombiner stringCombiner = words.
                reduce(new StringCombiner(" ", "[", "]"), StringCombiner::add, StringCombiner::merge);


        assertThat(stringCombiner.build()).isEqualTo("[Java is cool]");
    }

    @Test
    public void shouldJoinStringWithCustomizedCollector() throws Exception {
        String joined = words.collect(new MyStringJoiner(" ", "[", "]"));

        assertThat(joined).isEqualTo("[Java is cool]");
    }
}