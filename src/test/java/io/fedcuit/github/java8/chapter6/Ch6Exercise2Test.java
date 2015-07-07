package io.fedcuit.github.java8.chapter6;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.LongStream;

import static io.fedcuit.github.java8.chapter6.Ch6Exercise2.multiplyThrough;
import static io.fedcuit.github.java8.chapter6.Ch6Exercise2.slowSumOfSquares;
import static java.util.Arrays.asList;
import static org.fest.assertions.Assertions.assertThat;

public class Ch6Exercise2Test {


    @Test
    public void shouldMultiplyThrough() throws Exception {
        assertThat(multiplyThrough(asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))).isEqualTo(18144000);
    }

    @Test
    public void shouldBeSlowWhenCalculateSumOfSquaresUsingBadSourceDataStructure() throws Exception {
        List<Long> list = LongStream.range(1, 100000).collect(LinkedList::new, LinkedList::add, LinkedList::addAll);

        assertThat(slowSumOfSquares(list)).isEqualTo(333328333350000L);
    }

    @Test
    public void shouldBeQuickWhenCalculateSumOfSquaresUsingGoodSourceDataStructure() throws Exception {
        List<Long> list = LongStream.range(1, 100000).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        assertThat(slowSumOfSquares(list)).isEqualTo(333328333350000L);
    }

    @Test
    public void shouldAlwaysTrue() {
        List<Long> badSourceStructure = LongStream.range(1, 1000000).collect(LinkedList::new, LinkedList::add, LinkedList::addAll);
        List<Long> goodSourceStructure = LongStream.range(1, 1000000).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        Long start = System.currentTimeMillis();
        slowSumOfSquares(badSourceStructure);
        Long timeConsumedByBad = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        slowSumOfSquares(goodSourceStructure);
        Long timeConsumedByGood = System.currentTimeMillis() - start;

        assertThat(timeConsumedByGood).isLessThan(timeConsumedByBad);
    }
}