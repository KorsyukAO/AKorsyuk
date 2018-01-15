package ru.job4j;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *Test
 *
 *@autor Alexandr Korsyuk (Korsyuk@gmail.com)
 *@since 14.01.2018
 *@version 0.1
 */
public class CalculateTest {
	/**
	 *Test add.
	 */
	@Test
	public void whenAddOneToOneThenTwo() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		Calculate.main(null);
		assertThat(
				out.toString(),
				is(
						String.format(
								"Hello world.\r\n",
								System.getProperty("line.separator")
						)
				)
		);
	}

	/**
	 * Test echo.
	 */ @Test
	public void whenTakeNameThenTreeEchoPlusName() {
		String input = "Alexandr Korsyuk";
		String expect = "Echo, echo, echo : Alexandr Korsyuk";
		Calculate calc = new Calculate();
		String result = calc.echo(input);
		assertThat(result, is(expect));
	}
}