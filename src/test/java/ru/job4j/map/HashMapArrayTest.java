package ru.job4j.map;

import org.junit.Test;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class HashMapArrayTest {

    @Test
    public void whenInsertAndGet() {
        HashMapArray<String, Integer> map = new HashMapArray<>();
        map.insert("first", 1);
        map.insert("second", 2);
        map.insert("third", 15);
        assertThat(map.get("first"), is(1));
    }

    @Test
    public void whenInsertFalse() {
        HashMapArray<String, Integer> map = new HashMapArray<>();
        map.insert("first", 1);
        map.insert("second", 2);
        assertThat(map.insert("first", 3), is(false));
    }

    @Test
    public void whenDeleteTrue() {
        HashMapArray<String, Integer> map = new HashMapArray<>();
        map.insert("first", 1);
        map.insert("second", 2);
        map.insert("third", 15);
        assertThat(map.delete("first"), is(true));
    }

    @Test
    public void whenDeleteFalse() {
        HashMapArray<String, Integer> map = new HashMapArray<>();
        map.insert("first", 1);
        map.insert("second", 2);
        assertThat(map.delete("third"), is(false));
    }

    @Test
    public void whenIteratorNextFalse() {
        HashMapArray<String, Integer> map = new HashMapArray<>();
        map.insert("first", 1);
        map.insert("second", 2);
        Iterator<String> iterator = map.iterator();
        iterator.next();
        iterator.next();
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void whenIteratorNextTrue() {
        HashMapArray<String, Integer> map = new HashMapArray<>();
        map.insert("first", 1);
        map.insert("second", 2);
        map.insert("third", 15);
        Iterator<String> iterator = map.iterator();
        iterator.next();
        iterator.next();
        assertThat(iterator.hasNext(), is(true));
    }

    @Test
    public void whenNotElement() {
        HashMapArray<String, Integer> map = new HashMapArray<>();
        map.insert("first", 1);
        map.insert("second", 2);
        map.insert("third", 15);
        assertNull(map.get("Four"));
    }

    @Test
    public void whenExtend() {
        HashMapArray<String, Integer> map = new HashMapArray<>();
        map.insert("first", 1);
        map.insert("second", 2);
        map.insert("third", 15);
        map.insert("four", 3);
        map.insert("five", 5);
        map.insert("six", 19);
        map.insert("seven", 11);
        map.insert("eight", 8);
        map.insert("nine", 9);
        map.insert("ten", 10);
        Iterator<String> iterator = map.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        assertThat(iterator.hasNext(), is(true));
    }
}