package ru.job4j.arrey;
/**
 *Class Square решение задачи 5.0. Заполнить массив степенями чисел.
 *@autor Alexandr Korsyuk (Korsyuk@gmail.com)
 *@since 21.01.2018
 *@version 0.1
 */
public class Square {
    /**
     * метод calculate заносит в массив значения возведенные в квадрат.
     * @param bound - колличество элементов от 1 ... n в масиве.
     * @return возвращает масив из n элементов возведенных в квадрат.
     */
    public int[] calculate(int bound) {
        int[] rsl = new int[bound];
        for (int i = 0; i < bound; i++) {
            rsl[i] = i * i;
        }
        return rsl;
    }
}
