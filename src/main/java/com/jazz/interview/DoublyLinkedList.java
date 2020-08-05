package com.jazz.interview;


import com.jazz.interview.internal.Node;

import java.util.NoSuchElementException;

public class DoublyLinkedList extends AbstractSequenceList {

    transient int size = 0;
    private Node root;
    private Node end;

    public DoublyLinkedList() {
        this.root = null;
        this.end = null;
    }


    @Override
    public void add(int index, int item) {
        checkPositionInBounds(index);
        if (index == size)
            addLast(item);
        else
            addItemBefore(item, getNode(index));
    }

    @Override
    public void addFirst(int item) {
        final Node newNode = new Node(item, null, this.root);
        if (this.root == null)
            this.end = newNode;
        else
            this.root.addPrev(newNode);
        this.root = newNode;
        size++;
    }

    @Override
    public void addLast(int item) {
        final Node newNode = new Node(item, this.end, null);
        if (this.end == null)
            this.root = newNode;
        else
            this.end.addNext(newNode);
        this.end = newNode;
        size++;
    }

    @Override
    public void add(int item) {
        addLast(item);
    }

    @Override
    public int getFirst() {
        if (this.root == null)
            throw new NoSuchElementException();
        return this.root.getItem();

    }

    @Override
    public int getLast() {
        if (this.end == null)
            throw new NoSuchElementException();
        return this.end.getItem();
    }

    @Override
    public int get(int index) {
        final Node node = getNode(index);
        if (node == null)
            throw new NoSuchElementException();
        return node.getItem();
    }

    @Override
    public int set(int index, int item) {
        final Node node = getNode(index);
        if (node == null)
            throw new NoSuchElementException();
        node.setItem(item);
        return item;
    }

    /**
     * Adds the item before the node
     */
    private void addItemBefore(int item, Node node) {
        if (node != null) {
            final Node prev = node.getPrev();
            final Node newNode = new Node(item, prev, node);
            node.addPrev(newNode);
            if (prev == null)
                this.root = newNode;
            else
                prev.addNext(newNode);
            size++;
        }
    }

    /**
     * gets the node at the index if the index is valid
     */
    private Node getNode(int index) {
        if (isValidIndex(index)) {
            Node i = this.root;
            for (int x = 0; x < index; x++)
                i = i.getNext();
            return i;
        }
        return null;

    }

    /**
     * Checks whether the index is present already in the list
     */
    private boolean isValidIndex(int index) {
        return index >= 0 && index < size;
    }

    /**
     * Checks whether the index is valid for add operation
     */
    private void checkPositionInBounds(int index) {
        if (!(index >= 0 && index <= size)) {
            throw new IndexOutOfBoundsException(indexDetails(index));
        }
    }

    /**
     * Prints index and size
     */
    private String indexDetails(int index) {
        return "List size : " + size + " and index is : " + index;
    }


}
