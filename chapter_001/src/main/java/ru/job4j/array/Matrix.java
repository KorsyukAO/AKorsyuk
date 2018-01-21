package ru.job4j.array;
/**
 *Class Matrix решение задачи 5.4. Двухмерный массив. Таблица умножения.
 *@autor Alexandr Korsyuk (Korsyuk@gmail.com)
 *@since 21.01.2018
 *@version 0.1
 */
public class Matrix {
    /**
     * построении массива вида матица и заполнение его элементами таблицы умножения.
     * @param size - размер матрицы.
     * @return - возвращает матрицу размера size.
     */
    public int[][] multiple(int size) {
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = (i + 1) * (j + 1);
            }
        }
        return matrix;
    }
}
