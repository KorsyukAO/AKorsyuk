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
public class FindLoopTest {
    /**
     *Test - сравнение результата метода и эталонного значения.
     * Тест показывает корректное определение индекса расположения элемента в массиве.
     */
    @Test
    public void findIndexValueThreeInArray() {
        FindLoop loop = new FindLoop();
        int[] arrayLoop = {1, 2, 3, 4, 5};
        int result = loop.indexOf(arrayLoop, 3);
        int expIndex = 2;
        assertThat(result, is(expIndex));
    }

    /**
     * Test. тестирование резултата в случае если элемента нет в массиве.
     */
    @Test
    public void dontFindIndexValueSevenInArray() {
        FindLoop loop = new FindLoop();
        int[] arrayLoop = {1, 2, 3, 4, 5};
        int result = loop.indexOf(arrayLoop, 7);
        int expIndex = -1;
        assertThat(result, is(expIndex));
    }
}
