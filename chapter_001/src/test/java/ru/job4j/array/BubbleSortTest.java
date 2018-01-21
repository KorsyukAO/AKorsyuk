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
public class BubbleSortTest {
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        BubbleSort sortArray = new BubbleSort();
        int[] arrayNoSort = {5, 4, 3, 2, 1};
        int[] expectArray = {1, 2, 3, 4, 5};
        int[] resultArray = sortArray.sort(arrayNoSort);
        assertThat(resultArray, is(expectArray));
    }
}

