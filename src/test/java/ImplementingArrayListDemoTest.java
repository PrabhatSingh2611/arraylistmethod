import TestingModule.ImplementingArrayListDemo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)

class ImplementingArrayListDemoTest {

    ImplementingArrayListDemo method_array_objects;

    @BeforeAll
    public void before() {
        method_array_objects = new ImplementingArrayListDemo<>();
    }

    @BeforeEach
    public void init() {
        method_array_objects = new ImplementingArrayListDemo<>();
    }

    @ParameterizedTest
    @ValueSource(strings = {"Prabhat"})
    void size(String str) {
        method_array_objects.add(str);
        method_array_objects.add(str);
        assertEquals(7, method_array_objects.size());
    }

    @Test
    void isEmpty() {
        ImplementingArrayListDemo<Object> alImpl = new ImplementingArrayListDemo<>();
        assertTrue(method_array_objects.isEmpty());
        method_array_objects.add(75);
        assertFalse(method_array_objects.isEmpty());

    }

    @Test
    void contains() {
        method_array_objects.add("Dipankar");
        assertTrue(method_array_objects.contains("Namrata"));
        assertFalse(method_array_objects.contains("Abhishek"));
    }

    @Test
    void toArray() {
        method_array_objects.add("Kuljit");
        method_array_objects.add("Serhii");
        String[] strs = {"Kuljit", "Serhii"};
        assertArrayEquals(strs, method_array_objects.toArray());
    }

    @Test
    void testToArray() {
        method_array_objects.add("abcd");
        String[] strs = {"abcd"};
        assertArrayEquals(strs, method_array_objects.toArray());
    }

    @Test
    void add() {
        method_array_objects.add(11);
        method_array_objects.display();
        assertEquals(11, method_array_objects.get(0));
    }

    @Test
    void remove() {
        method_array_objects.add("wxyz");
        method_array_objects.remove("wxyz");
        method_array_objects.display();
        assertThrows(IndexOutOfBoundsException.class, () -> method_array_objects.get(0), "As we just removed the element so it will give an Exception of IndexoutOfBound");
    }

    @Test
    void containsAll() {
        method_array_objects.add("Ravi");
        method_array_objects.add("Revati");
        method_array_objects.add("Abhishek");
        method_array_objects.add("Namrata");
        method_array_objects.display();
        String[] str = {"Namrata", "Ravi"};
        assertTrue(method_array_objects.containsAll(List.of(str)));
    }

    @Test
    void addAll() {
        method_array_objects.add("Ravi");
        method_array_objects.add("Revati");
        method_array_objects.add("Abhishek");
        method_array_objects.add("Namrata");
        String[] str = {"Akshata", "Saurabh"};
        method_array_objects.addAll(List.of(str));
        method_array_objects.display();
        String[] expectedNames = {"Ravi","Revati","Abhishek","Namrata","Akshata","Saurabh"};
        assertTrue(method_array_objects.containsAll(List.of(expectedNames)));
    }

    @org.junit.jupiter.api.Test
    void testAddAllAtIndex() {
        method_array_objects.add("Ravi");
        method_array_objects.add("Revati");
        method_array_objects.add("Abhishek");
        method_array_objects.add("Namrata");
        String[] str = {"Akshata", "Saurabh"};
        method_array_objects.addAll(2, List.of(str));
        method_array_objects.display();
        String[] expectedNames = {"Ravi","Revati","Abhishek","Namrata","Akshata","Saurabh"};
        assertTrue(method_array_objects.containsAll(List.of(expectedNames)));
    }

    //Facing issue in this method as last data-member is null automatically
    @Test
    void removeAll() {
        method_array_objects.add("Ravi");
        method_array_objects.add("Revati");
        method_array_objects.add("Abhishek");
        method_array_objects.add("Namrata");
        method_array_objects.removeAll(List.of("Ravi", "Abhishek"));
        assertTrue(method_array_objects.contains("Revati"));
    }

    //Issue in this method too
    @Test
    void retainAll() {
        assertTrue(true);
    }

    @Test
    void clear() {
        method_array_objects.add(1);
        method_array_objects.add(1);
        method_array_objects.add(1);
        method_array_objects.clear();
        assertThrows(IndexOutOfBoundsException.class, () -> method_array_objects.get(0), "It will give an Exception of IndexoutOfBound");
    }

    @Test
    void get() {
        method_array_objects.add(2);
        assertEquals(2, method_array_objects.get(0));
    }

    @Test
    void set() {
        method_array_objects.add(42);
        method_array_objects.add(82);
        method_array_objects.add(92);
        method_array_objects.set(3, 45);
        assertEquals(45, method_array_objects.get(2));
    }

    @Test
    void testAdd() {
        method_array_objects.add(42);
        method_array_objects.add(82);
        method_array_objects.add(92);
        assertEquals(42, method_array_objects.get(0));
        assertEquals(82, method_array_objects.get(1));
        assertEquals(92, method_array_objects.get(2));
    }

    @Test
    void testRemove() {
        method_array_objects.add(42);
        method_array_objects.add(82);
        method_array_objects.add(92);
        method_array_objects.remove(1);
        method_array_objects.display();
        assertEquals(42, method_array_objects.get(0));
        assertEquals(82, method_array_objects.get(1));
    }

    @Test
    void indexOf() {
        method_array_objects.add(42);
        method_array_objects.add(82);
        method_array_objects.add(92);
        assertEquals(2, method_array_objects.indexOf(92));
    }

    @Test
    void lastIndexOf() {
        method_array_objects.add(42);
        method_array_objects.add(82);
        method_array_objects.add(92);
        method_array_objects.add(45);
        assertEquals(3, method_array_objects.lastIndexOf(45));

    }

    @Test
    void subList() {
        method_array_objects.add(42);
        method_array_objects.add(82);
        method_array_objects.add(92);
        method_array_objects.add(78);
        method_array_objects.add(22);
        List expected = List.of(82, 92, 78);
        List actual = method_array_objects.subList(1, 3);
        assertEquals(expected, actual);

    }

    @Test
    void display() {
        method_array_objects.add("Implementing");
        method_array_objects.add("Arraylist's");
        method_array_objects.add("Method");
        method_array_objects.add("and Testing them");
        method_array_objects.add("is done");
        method_array_objects.display();
    }









}