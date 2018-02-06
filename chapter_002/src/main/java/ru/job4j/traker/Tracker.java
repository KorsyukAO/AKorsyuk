package ru.job4j.traker;

import java.util.Arrays;
import java.util.Random;

public class Tracker {
    private final Item[] items = new Item[100];
    private int position = 0;
    private static final Random RN = new Random();

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
    /**
     * Метод реализаущий добавление заявки в массиве.
     * @param item новая заявка.
     */
    public Item add(Item item) {
        this.items[this.position++] = item;
        item.setId(generateId());
        return item;
    }

    /**
     * Метод реализующий редактирования заявки в массиве.
     * @param id заявки которую необходио отредактировать.
     * @param item новые значения заявки.
     */
    //редактирование заявок
    public void replace(String id, Item item) {
        for (int index = 0; index < position; index++) {
            if (id.equals(items[index].getId())) {
                this.items[index] = item;
                item.setId(id);
            }
        }
    }

    /**
     * Метод реализующий удаление завки из массива.
     * @param id удаляемой заявки.
     */
    //удаление заявок
    public void delete(String id) {
        for (int index = 0; index < position; index++) {
            if (id.equals(items[index].getId())) {
                this.items[index] = this.items[position];
                position--;
            }
        }
    }

    /**
     * Метод реализующий вывод всех заявок хранящихся в массива.
     * @return возвращает массив заявок.
     */
    //получение списка всех заявок -
    public Item[] getAll() {
        Item[] itemsResult = new Item[this.position];
        for (int index = 0; index < position; index++) {
            itemsResult[index] = this.items[index];
        }
        return itemsResult;
    }

    /**
     * метод реализующий поиск заявки по полю name.
     * @param key параметр имени искомой заявки.
     * @return возвращает массив заявок с указным значением имени.
     */
    public Item[] findByName(String key) {
        int counter = 0;
        Item[] itemsResult = new Item[position];
        for (int i = 0; i != this.position; i++) {
            if (items[i] != null && items[i].getName().equals(key)) {
                itemsResult[counter] = items[i];
                counter++;
            }
        }
        return Arrays.copyOf(itemsResult, counter);
    }

    /**
     * Метод реализующий поиск заявок по id.
     * @param id паметр искомой заявки.
     * @return возвращает заявку
     */
    //получение заявки по id -
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * допалнительный get для тестирования.
     * @param index индекс заявки в массиве.
     * @return возвращает заявку.
     */
    public Item getItemByIndex(int index) {
        return items[index];
    }
}
