package ru.job4j.pseudo.start;

import ru.job4j.pseudo.*;
/**
 *Class StartPseudo решение задачи:
 *002.4.4. Используя шаблон проектирования - стратегию [#786]
 *@autor Alexandr Korsyuk (Korsyuk@gmail.com).
 *@since 13.02.2018
 *@version 0.1
 */
public class StartPseudo {
    /**
     *
     * Start программы.
     */
    public static void main(String[] args) {
        Paint paint = new Paint();
        paint.draw(new Triangle());
        paint.draw(new Square());
    }
}
