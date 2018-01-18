package ru.job4j.loop;

/**
 *Class Max решение задачи 4.1. Подсчет суммы чётных чисел в диапазоне .
 *@autor Alexandr Korsyuk (Korsyuk@gmail.com).
 *@since 18.01.201
 *@version 0.1
 */
public class Counter {
    private int result = 0;

    /**
     * Метод раситывающий сумму четных чисел из диапазона.
     * @param start - начальное значение.
     * @param finish - конечное значение.
     * @return - сумму четных цифр.
     */
    public int add(int start, int finish) {

        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                result += i;
            }
        }
        return result;
    }
}
