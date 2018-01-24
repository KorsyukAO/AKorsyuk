package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate array = new ArrayDuplicate();
        String[] arrayDuplicates = {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] arrayResult = array.remove(arrayDuplicates);
        String[] arrayExp = {"Привет", "Мир", "Супер"};
        assertThat(arrayResult, arrayContainingInAnyOrder(arrayExp));
    }
}

