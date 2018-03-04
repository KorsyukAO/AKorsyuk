package ru.job4j.tracker;

/**
 * класс для проверки воодимых данных
 */
public class ValidateInput extends ConsoleInput {
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                //moe.printStackTrace(); - для отображение лога ошибки
                System.out.println("Необходимо ввести номер пункта меню");

            } catch (NumberFormatException nfe) {
                System.out.println("Необходимо ввести корректынй номер пункта меню.");
            }
        } while (invalid);
        return value;
    }
}