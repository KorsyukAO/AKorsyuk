package ru.job4j;
/**
 *Class Calculate решение задачи 1.1. Создание Hello World.
 *@autor Alexandr Korsyuk (Korsyuk@gmail.com)
 *@since 13.01.2018
 *@version 0.2
 */
public class Calculate {
	/**
	 *Конструктор, вывод строки в консоль.
	 *@param args - args
	 */
	public static void main(String[] args) {
		System.out.println("Hello world.");
	}

	/**
	 * Method echo.
	 * @param name Your name.
	 * @return Echo plus your name.
	 */
	public String echo(String name) {
		return "Echo, echo, echo : " + name;
	}
}