package com.jazz.interview;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DoublyLinkedListTest {

    @Test
    void checkEmptyList(){
        DoublyLinkedList dList = new DoublyLinkedList();
        assertEquals(0,dList.getSize());
    }


}




