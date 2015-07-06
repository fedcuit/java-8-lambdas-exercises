package io.fedcuit.github.java8.chapter5;

import org.junit.Test;

import static io.fedcuit.github.java8.chapter5.MethodReferenceExercise.*;
import static java.util.Arrays.asList;
import static org.fest.assertions.Assertions.assertThat;

public class MethodReferenceExerciseTest {
    @Test
    public void shouldMapListOfStringToUpperCase() throws Exception {
        assertThat(toUpperCase(asList("hello", "world"))).isEqualTo(asList("HELLO", "WORLD"));
    }

    @Test
    public void shouldCountListOfString() throws Exception {
        assertThat(countLetters(asList("hello", "world"))).isEqualTo(10);
    }

    @Test
    public void shouldConcatListsOfStrings() throws Exception {
        assertThat(concatenate(asList(asList("hello", "world"), asList("goodbye", "world")))).isEqualTo(asList("hello", "world", "goodbye", "world"));
    }
}