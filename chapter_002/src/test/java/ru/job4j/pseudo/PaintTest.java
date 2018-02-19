package ru.job4j.pseudo;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *Test
 *
 *@autor Alexandr Korsyuk (Korsyuk@gmail.com)
 *@since 19.02.2018
 *@version 0.2
 */

public class PaintTest {
    // поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenDrawSquare() {
        this.loadOutput();
        new Paint().draw(new Square());
        // проверяем результат вычисления
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(System.lineSeparator()).append("++++++++")
                                .append(System.lineSeparator()).append("++++++++")
                                .append(System.lineSeparator()).append("++++++++")
                                .append(System.lineSeparator()).append("++++++++")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
        this.backOutput();
    }

    @Test
    public void whenDrawTriangle() {
        this.loadOutput();
        new Paint().draw(new Triangle());
        // проверяем результат вычисления
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(System.lineSeparator()).append("   +   ")
                                .append(System.lineSeparator()).append("  +++   ")
                                .append(System.lineSeparator()).append(" +++++  ")
                                .append(System.lineSeparator()).append("+++++++")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
        // возвращаем обратно стандартный вывод в консоль.
        this.backOutput();
    }

}

