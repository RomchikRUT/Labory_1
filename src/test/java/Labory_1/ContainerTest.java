package Labory_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContainerTest {
    private Container container;

    @BeforeEach
    void setUp() {
        container = new Container();
    }

    @Test
    void testAddAndSize() {
        assertEquals(0, container.size());
        container.add("Первый элемент");
        assertEquals(1, container.size());
        container.add("Второй элемент");
        assertEquals(2, container.size());
        container.add("Третий элемент");
        assertEquals(3, container.size());
    }

    @Test
    void testGet() {
        container.add("Первый элемент");
        container.add("Второй элемент");
        container.add("Третий элемент");

        assertEquals("Первый элемент", container.get(0));
        assertEquals("Второй элемент", container.get(1));
        assertEquals("Третий элемент", container.get(2));
    }

    @Test
    void testGetIndexOutOfBounds() {
        container.add("Первый элемент");

        assertThrows(IndexOutOfBoundsException.class, () -> {
            container.get(1);
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            container.get(-1);
        });
    }

    @Test
    void testRemove() {
        container.add("Первый элемент");
        container.add("Второй элемент");
        container.add("Третий элемент");

        assertEquals(3, container.size());

        container.remove(1); // Удаляем "Второй элемент"
        assertEquals(2, container.size());
        assertEquals("Первый элемент", container.get(0));
        assertEquals("Третий элемент", container.get(1));
    }

    @Test
    void testRemoveIndexOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            container.remove(0);
        });

        container.add("Первый элемент");

        assertThrows(IndexOutOfBoundsException.class, () -> {
            container.remove(1);
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            container.remove(-1);
        });
    }
}