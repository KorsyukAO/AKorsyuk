package ru.job4j.tracker;

import ru.job4j.tracker.start.*;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    /**
     * 0. Создание новой заявки.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.getAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    /**
     * 2. Редоктирование заявки.
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
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
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "name"));
        Item item1 = tracker.add(new Item("name1", "name1"));
        Item item2 = tracker.add(new Item("name2", "name2"));
        Item[] result = {item1, item2};
        Input input = new StubInput(new String[]{"1", "3", item.getId(), "1", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll(), is(result));
    }
}
