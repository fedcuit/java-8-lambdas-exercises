package io.fedcuit.github.java8.chapter5;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    private final Map<Integer, Long> cache;

    public Fibonacci() {
        this.cache = new HashMap<>();
        cache.put(0, 0L);
        cache.put(1, 1L);
    }

    public long fib(int i) {
        return cache.computeIfAbsent(i, x -> fib(x - 1) + fib(x - 2));
    }

//    public long fib(int i) {
//        if (cache.containsKey(i)) {
//            return cache.get(i);
//        } else {
//            return fib(i - 1) + fib(i - 2);
//        }
//    }
}
