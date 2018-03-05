package ru.job4j.tracker;

/**
 * интерфейс меню.
 */
public interface UserAction {
    // интерфейс который принимает значения действия пользователя.
    int key();
    // выполнение действий меню.
    void execute(Input input, Tracker tracker);
    // выводит информацию о выбраном пункте меню.
    String info();

}
