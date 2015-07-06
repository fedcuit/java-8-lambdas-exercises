package io.fedcuit.github.java8.chapter5;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;


public class FibonacciTest {
    @Test
    public void shouldGenerateFibonacciSequence() throws Exception {
        Fibonacci fibonacci = new Fibonacci();

        assertThat(fibonacci.fib(0)).isEqualTo(0);
        assertThat(fibonacci.fib(1)).isEqualTo(1);
        assertThat(fibonacci.fib(2)).isEqualTo(1);
        assertThat(fibonacci.fib(3)).isEqualTo(2);
        assertThat(fibonacci.fib(4)).isEqualTo(3);
        assertThat(fibonacci.fib(5)).isEqualTo(5);
        assertThat(fibonacci.fib(6)).isEqualTo(8);
        assertThat(fibonacci.fib(7)).isEqualTo(13);
    }
}