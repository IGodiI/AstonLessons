package HomeWork.HW3_List;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;


public class MyLinkedListTest {



    @Test
    public void testAdd() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(2), list.get(1));
        assertEquals(Integer.valueOf(3), list.get(2));
        System.out.println(list.get(2));
    }

    @Test
    public void testAddAllWithIndex() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(3);

        Collection<Integer> collection = Arrays.asList(2, 4);
        list.addAll(1, collection);

        assertEquals(4, list.size());
        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(2), list.get(1));
        assertEquals(Integer.valueOf(4), list.get(2));
        assertEquals(Integer.valueOf(3), list.get(3));
    }

    @Test
    public void testGet() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("first");
        list.add("second");
        list.add("third");

        assertEquals("first", list.get(0));
        assertEquals("second", list.get(1));
        assertEquals("third", list.get(2));

        // Тест на выход за границы индекса
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));
    }

    @Test
    public void testSet() {
        MyLinkedList<Double> list = new MyLinkedList<>();
        list.add(1.0);
        list.add(2.0);

        assertEquals(Double.valueOf(2.0), list.set(1, 3.0));
        assertEquals(Double.valueOf(3.0), list.get(1));
        assertEquals(2, list.size());

        // Тест на выход за границы индекса
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(-1, 4.0));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(2, 4.0));
    }

    @Test
    public void testRemove() {
        MyLinkedList<Character> list = new MyLinkedList<>();
        list.add('a');
        list.add('b');
        list.add('c');

        assertEquals(Character.valueOf('b'), list.remove(1));
        assertEquals(2, list.size());
        assertEquals(Character.valueOf('a'), list.get(0));
        assertEquals(Character.valueOf('c'), list.get(1));

        // Тест на выход за границы индекса
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
    }
}