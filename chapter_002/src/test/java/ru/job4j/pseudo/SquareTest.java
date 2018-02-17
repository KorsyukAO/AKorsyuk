package ru.job4j.pseudo;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *Test
 *
 *@autor Alexandr Korsyuk (Korsyuk@gmail.com)
 *@since 13.02.2018
 *@version 0.1
 */

public class SquareTest {
    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        assertThat(square.draw(), is(
                new StringBuilder()
                        .append(System.lineSeparator()).append("++++++++")
                        .append(System.lineSeparator()).append("++++++++")
                        .append(System.lineSeparator()).append("++++++++")
                        .append(System.lineSeparator()).append("++++++++")
                        .toString()
                )
        );
    }
}
