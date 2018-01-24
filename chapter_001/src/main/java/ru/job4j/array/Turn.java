package ru.job4j.array;
/**
 *Class Turn решение задачи 5.2. Перевернуть массив.
 *@autor Alexandr Korsyuk (Korsyuk@gmail.com)
 *@since 21.01.2018
 *@version 0.1
 */
public class Turn {
    /**
     * метод back переворачивает массив задом на перед.
     * @param array - входящий массив.
     * @return - развернутый массив.
     */
    public int[] back(int[] array) {

        for (int i = 0; i < array.length / 2; i++) {
            int x = array[i];
            array[i] = array[array.length - (1 + i)];
            array[array.length - (1 + i)] = x;
        }
        return array;
    }
}
