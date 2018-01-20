package ru.job4j.loop;
/**
 *Class Board решение задачи 4.3. Построить шахматную доску в псевдографике.
 *@autor Alexandr Korsyuk (Korsyuk@gmail.com).
 *@since 20.01.2018
 *@version 0.1
 */
public class Board {
    /**
     * Метод paint строит шахматную доску в псевдографике.
     *
     * @param width - ширина доски.
     * @param height - длина доски.
     * @return - возвращает хранящиеся строки из обьекта screen.
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (j % 2 == 0 && i % 2 == 0 || j % 2 == 1 && i % 2 == 1) {
                    screen.append("x");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}
