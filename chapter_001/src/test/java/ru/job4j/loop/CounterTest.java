package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *Test
 *
 *@autor Alexandr Korsyuk (Korsyuk@gmail.com)
 *@since 17.01.2018
 *@version 0.1
 */
public class CounterTest {
    /**
     *Test add evens numbers.
     */
    @Test
    public void additionTwoEvenNumber() {
        Counter counter = new Counter();
        assertThat(counter.add(1, 4), is(6));
    }

}
