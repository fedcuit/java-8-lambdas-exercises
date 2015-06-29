package io.fedcuit.github.java8.chapter2;

import java.util.function.Predicate;

public class TestOverride {
    boolean check(Predicate<Integer> predicate) {
        return false;
    }

// This method will results in a compilation error, because both methods'
// functional interface type has the same method signature.
//
//    boolean check(IntPred predicate) {
//        return false;
//    }

    public static void main(String[] args) {
        TestOverride testOverride = new TestOverride();
        testOverride.check(x -> x > 5);
    }
}
