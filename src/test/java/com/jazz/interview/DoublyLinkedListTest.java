package com.jazz.interview;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DoublyLinkedListTest {

    @Test
    void addWhenEmpty() {
        DoublyLinkedList dList = new DoublyLinkedList();
        dList.add(5);

        assertSingleElementList(dList, 5);
    }

    @Test
    void addWithIndexWhenEmpty() {
        DoublyLinkedList dList = new DoublyLinkedList();
        dList.add(0, 5);

        assertSingleElementList(dList, 5);
    }

    @Test
    void addFirstWhenEmpty() {
        DoublyLinkedList dList = new DoublyLinkedList();
        dList.addFirst(5);

        assertSingleElementList(dList, 5);
    }

    @Test
    void addLastWhenEmpty() {
        DoublyLinkedList dList = new DoublyLinkedList();
        dList.addLast(5);

        assertSingleElementList(dList, 5);
    }

    @Test
    void addWhenNonEmpty() {
        DoublyLinkedList dList = new DoublyLinkedList();
        dList.add(5);
        dList.add(7);

        dList.add(6);
        assertEquals(5, dList.getFirst());
        assertEquals(6, dList.getLast());
        assertEquals(5, dList.get(0));
        assertEquals(7, dList.get(1));
    }

    @Test
    void addWithIndexWhenNonEmpty() {
        DoublyLinkedList dList = new DoublyLinkedList();
        dList.add(5);
        dList.add(7);

        dList.add(1, 6);
        assertEquals(5, dList.getFirst());
        assertEquals(7, dList.getLast());
        assertEquals(5, dList.get(0));
        assertEquals(6, dList.get(1));
    }

    @Test
    void addWithLastIndexWhenNonEmpty() {
        DoublyLinkedList dList = new DoublyLinkedList();
        dList.add(5);
        dList.add(7);

        dList.add(2, 6);
        assertEquals(5, dList.getFirst());
        assertEquals(6, dList.getLast());
        assertEquals(5, dList.get(0));
        assertEquals(7, dList.get(1));
    }

    @Test
    void addWithZeroIndexWhenNonEmpty() {
        DoublyLinkedList dList = new DoublyLinkedList();
        dList.add(5);
        dList.add(7);

        dList.add(0, 6);
        assertEquals(6, dList.getFirst());
        assertEquals(7, dList.getLast());
        assertEquals(6, dList.get(0));
        assertEquals(5, dList.get(1));
    }


    @Test
    void addFirstWhenNonEmpty() {
        DoublyLinkedList dList = new DoublyLinkedList();
        dList.add(5);
        dList.add(7);

        dList.addFirst(6);
        assertEquals(6, dList.getFirst());
        assertEquals(7, dList.getLast());
        assertEquals(6, dList.get(0));
        assertEquals(5, dList.get(1));
        assertEquals(7, dList.get(2));
    }

    @Test
    void addLastWhenNonEmpty() {
        DoublyLinkedList dList = new DoublyLinkedList();
        dList.add(5);
        dList.add(7);

        dList.addLast(6);
        assertEquals(5, dList.getFirst());
        assertEquals(6, dList.getLast());
        assertEquals(5, dList.get(0));
        assertEquals(7, dList.get(1));
    }

    @Test
    void getFirstWhenEmpty() {
        DoublyLinkedList dList = new DoublyLinkedList();
        assertThrows(NoSuchElementException.class, () -> {
            dList.getFirst();
        });
    }

    @Test
    void getLastWhenEmpty() {
        DoublyLinkedList dList = new DoublyLinkedList();
        assertThrows(NoSuchElementException.class, () -> {
            dList.getLast();
        });
    }

    @Test
    void getWithWhenEmpty() {
        DoublyLinkedList dList = new DoublyLinkedList();
        assertThrows(NoSuchElementException.class, () -> {
            dList.get(0);
        });
    }

    @Test
    void addWhenEmptyWithWrongIndex() {
        DoublyLinkedList dList = new DoublyLinkedList();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            dList.add(2, 4);
        });
    }

    @Test
    void addWhenNonEmptyWithWrongIndex() {
        DoublyLinkedList dList = new DoublyLinkedList();
        dList.add(7);
        dList.add(8);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            dList.add(8, 8);
        });
    }


    private void assertSingleElementList(DoublyLinkedList dList, int value) {
        assertEquals(value, dList.getFirst());
        assertEquals(value, dList.getLast());
        assertEquals(value, dList.get(0));
    }


}




