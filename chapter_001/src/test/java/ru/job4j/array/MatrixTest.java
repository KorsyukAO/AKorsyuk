package ru.job4j.array;

/**
 *
 *@autor Alexandr Korsyuk (Korsyuk@gmail.com)
 *@since 21.01.2018
 *@version 0.1
 */
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixTest {

    @Test
    public void whenCreateMatrixArrayTenOnTenAndEquateFourthLine() {
        Matrix matrix = new Matrix();
        int[][] arrayMatrix = matrix.multiple(10);
        int[] result = arrayMatrix[3];
        int[] expArray = {4, 8, 12, 16, 20, 24, 28, 32, 36, 40};
        assertThat(result, is(expArray));
    }
}
