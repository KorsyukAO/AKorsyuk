package ru.job4j.tracker;

/**
 *
 *интерефейс опроса пользователя.
 */
public interface Input {
    String ask(String question);

    int ask(String question, int[] range);
}
