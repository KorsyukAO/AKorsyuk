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

public class TriangleTest {
    @Test
    public void whenDrawTriangle() {
        Triangle triangle = new Triangle();
        assertThat(triangle.draw(), is(
                new StringBuilder()
                        .append('\n').append("   +   ")
                        .append('\n').append("  +++   ")
                        .append('\n').append(" +++++  ")
                        .append('\n').append("+++++++")
                        .toString()
                )
        );
    }
}
