package ru.job4j.traker;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertArrayEquals;

public class TrackerTest {
    /**
     * 1.Test Add
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.getAll()[0], is(item));
    }

    /**
     * 2.Test replace
     */
    @Test
    public void whenReplaceItemInTracker() {
       }


    /**
     * 2.Test delete
     */
    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item item = new Item("test3", "testDescription", 123L);
        Item item2 = new Item("test3", "testDescription", 123L);
        Item item3 = new Item("test3", "testDescription", 123L);
        tracker.add(item);
        tracker.add(item2);
        tracker.add(item3);
        Item[] expected = {item, item2, item3};
        tracker.delete(item2.getId());
        assertArrayEquals(tracker.getAll(),expected);
    }
    /**
     * 2.Test getAll
     */
    @Test
    public void whenGetAll() {
        Tracker tracker = new Tracker();
        Item item = new Item("test3", "testDescription", 123L);
        Item item2 = new Item("test3", "testDescription", 123L);
        tracker.add(item);
        tracker.add(item2);
        Item[] expected = {item, item2};
        assertArrayEquals(expected, tracker.getAll());
    }
    /**
     * 3.Test findByName
     */
    @Test
    public void whenFindItemByNameInTracker() {
        Tracker tracker = new Tracker();
        Item item = new Item("test3", "testDescription", 123L);
        Item item2 = new Item("test3", "testDescription", 123L);
        tracker.add(item);
        tracker.add(item2);
        String name = "test3";
        Item[] expected = {item, item2};
        assertThat(tracker.findByName(name), is(expected));
    }
    /**
     * 4.Test findById
     */
    @Test
    public void whenFindItemByIdInTracker() {
        Tracker tracker = new Tracker();
        Item item = new Item("test2", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }


}
