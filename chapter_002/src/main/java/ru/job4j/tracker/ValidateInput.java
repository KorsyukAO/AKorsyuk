package ru.job4j.tracker;

/**
 * класс для проверки воодимых данных.
 * отлавливает ошибки в случае не корректного ввода данных.
 */
public class ValidateInput implements Input {
    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
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