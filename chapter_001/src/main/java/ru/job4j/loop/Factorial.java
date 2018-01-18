package ru.job4j.loop;
/**
 *Class Factorial решение задачи 4.2. Создать программу вычисляющую факториал. [#193] .
 *@autor Alexandr Korsyuk (Korsyuk@gmail.com).
 *@since 18.01.201
 *@version 0.1
 */
public class Factorial {
    private int x = 1;

    /**
     * Метод вычисляет ффакториал.
     * @param n - начальное значение.
     * @return - факториал числа n.
     */
    public int calc(int n) {
        for (int i = 1; i <= n; i++) {
            x *= i;
        }
        return x;
    }

}