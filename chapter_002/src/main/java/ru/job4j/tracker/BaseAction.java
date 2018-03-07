package ru.job4j.tracker;

/**
 *Задание: 1. Рефакторинг - Перенести общие методы в абстрактный класс [#790]
 *@autor Alexandr Korsyuk (Korsyuk@gmail.com).
 *@since 07.03.2018
 *@version 0.1
 */
public abstract class BaseAction implements UserAction {
    private final int key;
    private final String name;

    protected BaseAction(final int key, final String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public int key() {
        return  this.key;
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key, this.name);
    }


}
