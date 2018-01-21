package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *Test
 *
 *@autor Alexandr Korsyuk (Korsyuk@gmail.com)
 *@since 21.01.2018
 *@version 0.1
 */
public class TurnTest {

    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        Turn turn = new Turn();
        int[] arrayTest = {4, 1, 6, 2};
        int[] expectArray = {2, 6, 1, 4};
        int[] resultArray = turn.back(arrayTest);
        assertThat(resultArray, is(expectArray));
    }

    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
        Turn turn = new Turn();
        int[] arrayTest = {1, 2, 3, 4, 5};
        int[] expectArray = {5, 4, 3, 2, 1};
        int[] resultArray = turn.back(arrayTest);
        assertThat(resultArray, is(expectArray));
    }
}
