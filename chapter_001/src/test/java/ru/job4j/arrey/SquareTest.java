package ru.job4j.arrey;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
/**
 *Test
 *
 *@autor Alexandr Korsyuk (Korsyuk@gmail.com)
 *@since 21.01.2018
 *@version 0.1
 */
public class SquareTest {
    /**
     *Test сравниваем результат рботы методв с эталонным для bound = 5.
     *
     */
    @Test
    public void testArreyValueOfFive() {
        Square square = new Square();
        int[] rst = square.calculate(5);
        int[] expArray = {0, 1, 4, 9, 16};
        assertArrayEquals(rst, expArray);

    }
}
