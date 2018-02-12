package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *Test
 *
 *@autor Alexandr Korsyuk (Korsyuk@gmail.com)
 *@since 12.02.2018
 *@version 0.1
 */
public class ContainsWorldTest {
    ContainsWorld containsWorld = new ContainsWorld();
    @Test
    public void whenFindWordContainsInEnd() {
        assertThat(containsWorld.contains("kkertetekkors", "kors"), is(true));
    }
    @Test
    public void whenFindWordContainsInStart() {
        assertThat(containsWorld.contains("korsqweqwsdf", "kors"), is(true));
    }
    @Test
    public void whenFindWorldNotContains() {
        assertThat(containsWorld.contains("k@o@r@s@qwe", "kors"), is(false));
    }
    @Test
    public void whenFindWorldContainsInCentre() {
        assertThat(containsWorld.contains("erwkorsqwe", "kors"), is(true));
    }
}
