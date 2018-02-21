package ru.job4j.tracker;

import ru.job4j.tracker.start.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    private Tracker tracker = new Tracker();
    // поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    /**
     * 0. Создание новой заявки.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        //   создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.getAll()[0].getName(), is("test name"));
    }

    /**
     * 2. Редоктирование заявки.
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item());
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"1", "2", item.getId(), "test name", "desc", "1", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }
    /**
     * 3. Удаление заявки.
     */
    @Test
    public void whenDeleteItemsThenTracker() {
        Item item = tracker.add(new Item("name", "name"));
        Item item1 = tracker.add(new Item("name1", "name1"));
        Item item2 = tracker.add(new Item("name2", "name2"));
        Item[] result = {item1, item2};
        Input input = new StubInput(new String[]{"1", "3", item.getId(), "1", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll(), is(result));
    }
    /**
     * 1. Вывод всех заявок из хранилища.
     */
    @Test
    public void whenOutputAllItems() {
        Item item = tracker.add(new Item("name", "name"));
        Item item1 = tracker.add(new Item("name1", "name1"));
        Item item2 = tracker.add(new Item("name2", "name2"));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("0. Создание новой заявки.")
                                .append(System.lineSeparator()).append("1. Вывод всех заявок на экран.")
                                .append(System.lineSeparator()).append("2. Редоктирование заявки.")
                                .append(System.lineSeparator()).append("3. Удаление заявки.")
                                .append(System.lineSeparator()).append("4. Поиск заявки по ID.")
                                .append(System.lineSeparator()).append("5. Поиск заявки по имени.")
                                .append(System.lineSeparator()).append("6. Выход из программы.")
                                .append(System.lineSeparator()).append("------------ Вывод всех заявок --------------")
                                .append(System.lineSeparator()).append("Заявка: ID: ").append(item.getId()).append("   Имя: name                 Описание: name                ")
                                .append(System.lineSeparator()).append("Заявка: ID: ").append(item1.getId()).append("   Имя: name1                Описание: name1               ")
                                .append(System.lineSeparator()).append("Заявка: ID: ").append(item2.getId()).append("   Имя: name2                Описание: name2               ")
                                .append(System.lineSeparator()).append("------------ Вывод всех заявок --------------")
                                .append(System.lineSeparator()).append("0. Создание новой заявки.")
                                .append(System.lineSeparator()).append("1. Вывод всех заявок на экран.")
                                .append(System.lineSeparator()).append("2. Редоктирование заявки.")
                                .append(System.lineSeparator()).append("3. Удаление заявки.")
                                .append(System.lineSeparator()).append("4. Поиск заявки по ID.")
                                .append(System.lineSeparator()).append("5. Поиск заявки по имени.")
                                .append(System.lineSeparator()).append("6. Выход из программы.")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
}
