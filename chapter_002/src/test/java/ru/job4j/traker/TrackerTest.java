package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertArrayEquals;

public class TrackerTest {
    Item item0 = new Item("name0", "desc0", 0000);
    Item item1 = new Item("name1", "desc1", 0001);
    Item item2 = new Item("name2", "desc2", 0002);
    Item item3 = new Item("name3", "desc3", 0003);
    Item item4 = new Item("name4", "desc4", 0004);
    Item item5 = new Item("name5", "desc5", 0005);
    Item item6 = new Item("name3", "desc6", 0006);

    private Tracker addTrackerTestItems() {
        Tracker tracker = new Tracker();
        tracker.add(item0);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        tracker.add(item5);
        tracker.add(item6);
        return tracker;
    }

    Tracker tracker = addTrackerTestItems();

    /**
     * 1.Test Add
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        tracker.add(this.item0);
        assertThat(tracker.getAll()[0], is(this.item0));
    }

    /**
     * 2.Test replace
     */
    @Test
    public void whenReplaceItemInTracker() {
        Item item7 = new Item();
        tracker.add(item7);
        tracker.replace(item7.getId(), item0);
        assertThat(tracker.getItemByIndex(7), is(item0));

    }


    /**
     * 3.Test delete
     */
    @Test
    public void whenDelete() {
        Item[] expected = {this.item0, this.item1, this.item2, this.item3, this.item4, this.item5};
        tracker.delete(item6.getId());
        assertArrayEquals(expected, tracker.getAll());
    }
    /**
     * 4.Test getAll
     */
    @Test
    public void whenGetAll() {
        Item[] expected = {this.item0, this.item1, this.item2, this.item3, this.item4, this.item5, this.item6};
        assertArrayEquals(expected, tracker.getAll());
    }
    /**
     * 5.Test findByName
     */
    @Test
    public void whenFindItemByNameInTracker() {
        String name = "name3";
        Item[] expected = {item3, item6};
        assertThat(tracker.findByName(name), is(expected));
    }

    /**
     * 6.Test findById
     */
    @Test
    public void whenFindItemByIdInTracker() {
        assertThat(tracker.findById(item6.getId()), is(item6));
    }
}
