package com.jazz.interview;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

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
        assertEquals(3,dList.getSize());
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
        assertEquals(3,dList.getSize());
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
        assertEquals(3,dList.getSize());
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
        assertEquals(3,dList.getSize());
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
        assertEquals(3,dList.getSize());
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
        assertEquals(3,dList.getSize());
    }

    @Test
    void setWhenNonEmpty() {
        DoublyLinkedList dList = new DoublyLinkedList();
        dList.add(5);
        dList.add(7);

        dList.set(1,6);
        assertEquals(5, dList.getFirst());
        assertEquals(6, dList.getLast());
        assertEquals(5, dList.get(0));
        assertEquals(6, dList.get(1));
        assertEquals(2,dList.getSize());
    }

    @Test
    void removeFirstWhenSingleEntryList(){
        DoublyLinkedList dList = new DoublyLinkedList();
        dList.add(5);

        dList.removeFirst();
        assertEmptyList(dList);
    }

    @Test
    void removeWithIndexWhenSingleEntryList(){
        DoublyLinkedList dList = new DoublyLinkedList();
        dList.add(5);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            dList.remove(1);;
        });
        dList.remove(0);
        assertEmptyList(dList);
    }

    @Test
    void removeLastWhenSingleEntryList(){
        DoublyLinkedList dList = new DoublyLinkedList();
        dList.add(5);

        dList.removeLast();
        assertEmptyList(dList);
    }

    @Test
    void removeFirstWhenNonEmpty(){
        DoublyLinkedList dList = new DoublyLinkedList();
        dList.add(5);
        dList.add(7);

        dList.removeFirst();
        assertSingleElementList(dList, 7);
    }

    @Test
    void removeFirstWithIndexWhenNonEmpty(){
        DoublyLinkedList dList = new DoublyLinkedList();
        dList.add(5);
        dList.add(7);

        dList.remove(0);
        assertSingleElementList(dList, 7);
    }
    @Test
    void removeLastWithIndexWhenNonEmpty(){
        DoublyLinkedList dList = new DoublyLinkedList();
        dList.add(5);
        dList.add(7);

        dList.remove(1);
        assertSingleElementList(dList, 5);
    }

    @Test
    void removeMiddleWithIndexWhenNonEmpty(){
        DoublyLinkedList dList = new DoublyLinkedList();
        dList.add(5);
        dList.add(6);
        dList.add(7);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            dList.remove(-1);;
        });

        dList.remove(1);
        assertEquals(5, dList.getFirst());
        assertEquals(7, dList.getLast());
        assertEquals(5, dList.get(0));
        assertEquals(7, dList.get(1));
        assertEquals(2,dList.getSize());

    }

    @Test
    void removeLastWhenNonEmpty(){
        DoublyLinkedList dList = new DoublyLinkedList();
        dList.add(5);
        dList.add(7);

        dList.removeLast();
        assertSingleElementList(dList, 5);
    }

    @Test
    void removeFirstOccurrenceInAnEmptyList(){
        DoublyLinkedList dList = new DoublyLinkedList();
        assertFalse(dList.removeFirstOccurrence(10));
        assertEmptyList(dList);
    }
    @Test
    void removeFirstOccurrenceInAnNonEmptyList(){
        DoublyLinkedList dList = new DoublyLinkedList();
        dList.add(5);
        assertTrue(dList.removeFirstOccurrence(5));
        assertEmptyList(dList);
    }

    @Test
    void removeInvalidFirstOccurrenceInAnNonEmptyList(){
        DoublyLinkedList dList = new DoublyLinkedList();
        dList.add(5);
        assertFalse(dList.removeFirstOccurrence(10));
        assertSingleElementList(dList, 5);
    }

    @Test
    void removeFirstOccurrenceInAnNonEmptyBigList(){
        DoublyLinkedList dList = new DoublyLinkedList();
        dList.add(5);
        dList.add(10);
        dList.add(15);
        dList.add(20);

        assertTrue(dList.removeFirstOccurrence(10));
        assertEquals(3, dList.getSize());
    }

    @Test
    void removeFirstOccurrenceInAnNonEmptyBigListWithDuplicates(){
        DoublyLinkedList dList = new DoublyLinkedList();
        dList.add(5);
        dList.add(10);
        dList.add(10);
        dList.add(10);

        assertTrue(dList.removeFirstOccurrence(10));
        assertEquals(3, dList.getSize());
    }

    @Test
    void setWithEmpty(){
        DoublyLinkedList dList = new DoublyLinkedList();
        assertEquals(0,dList.getSize());
        assertThrows(IndexOutOfBoundsException.class, () -> {
            dList.set(2,20);
        });
    }

    @Test
    void setWithWrongIndexWhenNotEmpty(){
        DoublyLinkedList dList = new DoublyLinkedList();
        dList.add(5);
        dList.add(7);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            dList.set(4,20);
        });
    }


    @Test
    void getWhenEmpty() {
        DoublyLinkedList dList = new DoublyLinkedList();
        assertThrows(NoSuchElementException.class, () -> {
            dList.getLast();
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            dList.get(0);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            dList.get(-2);
        });
        assertThrows(NoSuchElementException.class, () -> {
            dList.getFirst();
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
    void addWithNegativeIndex() {
        DoublyLinkedList dList = new DoublyLinkedList();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            dList.add(-2, 4);
        });
    }

    @Test
    void addWhenNonEmptyWithWrongIndex() {
        DoublyLinkedList dList = new DoublyLinkedList();
        dList.add(7);
        dList.add(8);
        assertEquals(2,dList.getSize());
        assertThrows(IndexOutOfBoundsException.class, () -> {
            dList.add(8, 8);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            dList.add(-8, 8);
        });
    }

    @Test
    void removeWhenEmpty(){
        DoublyLinkedList dList = new DoublyLinkedList();
        assertThrows(NoSuchElementException.class, () -> {
            dList.removeFirst();
        });
        assertThrows(NoSuchElementException.class, () -> {
            dList.removeLast();
        });
    }


    private void assertSingleElementList(DoublyLinkedList dList, int value) {
        assertEquals(value, dList.getFirst());
        assertEquals(value, dList.getLast());
        assertEquals(value, dList.get(0));
        assertEquals(1,dList.getSize());
    }

    private void assertEmptyList(DoublyLinkedList dList){
        assertEquals(0,dList.getSize());
        assertThrows(NoSuchElementException.class, () -> {
            dList.getFirst();
        });
        assertThrows(NoSuchElementException.class, () -> {
            dList.getLast();
        });
    }


}




