package ru.job4j.array;
/**
 *Class FindLoop решение задачи 5.1. Классический поиск перебором.
 *@autor Alexandr Korsyuk (Korsyuk@gmail.com)
 *@since 21.01.2018
 *@version 0.1
 */
public class FindLoop {
    /**
     * Метод поиска индекса элемента в масиве.
     * @param data- input array.
     * @param el - искомое значение.
     * @return - index элемента найденого в array или -1.
     */
    public int indexOf(int[] data, int el) {
        int rsl = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int index = 0; index < data.length - 1; index++) {

            if (data[index] == el) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }
}
