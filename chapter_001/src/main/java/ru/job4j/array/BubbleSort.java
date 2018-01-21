package ru.job4j.array;
/**
 *Class BubbleSort решение задачи:
 *5.3. Создать программу для сортировки массива методом перестановки.
 *@autor Alexandr Korsyuk (Korsyuk@gmail.com).
 *@since 21.01.2018
 *@version 0.1
 */
public class BubbleSort {
    /**
     * Метод сортирует массив с помощью перестоновки.
     * @param array - input массив.
     * @return - отсортированный массив.
     */
    public int[] sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - (1 + i); j++) {
                if (array[j] > array [j + 1]) {
                    int x = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = x;
                }
            }
        }
        return array;
    }
}