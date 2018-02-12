package ru.job4j.array;
/**
 *Class FindLoop решение задачи 7 Проверка, что одно слово находится в другом слове [#228]
 *@autor Alexandr Korsyuk (Korsyuk@gmail.com)
 *@since 12.02.2018
 *@version 0.1
 */
public class ContainsWorld {
    /**
     * Метод contains определяет включает ли в себя слово "origin" слово "sub".
     * @param origin
     * @param sub
     * @return возвращает результат иследования.
     */
    public boolean contains(String origin, String sub) {
        char[] originChar = origin.toCharArray();
        char[] subChar = sub.toCharArray();
        int count = 0;
        boolean result = false;

        for (int i = 0; i < originChar.length; i++) {
            if (originChar[i] == subChar[0]) {
                for (int j = 0; j < subChar.length; j++) {
                    if (originChar[i] == subChar[j]) {
                        i++;
                        count++;
                    } else {
                        i = i - (count);
                        count = 0;
                        break;
                    }
                }
            }
            if (count == subChar.length) {
                result = true;
                break;
            }
        }
        return result;
    }
}
