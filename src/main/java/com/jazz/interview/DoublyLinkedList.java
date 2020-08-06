package com.jazz.interview;


import com.jazz.interview.internal.Node;

import java.util.Collection;
import java.util.NoSuchElementException;

public class DoublyLinkedList extends AbstractSequenceList {

    transient int size = 0;
    private Node root;
    private Node end;

    public DoublyLinkedList() {
        this.root = null;
        this.end = null;
    }

    public DoublyLinkedList(Collection<Integer> c) {
        this();
        addAll(c);
    }

    /**
     * Adds the item at the provided Index
     */
    @Override
    public void add(int index, int item) {
        checkPositionInBounds(index);
        if (index == size)
            addLast(item);
        else
            addItemBefore(item, getNode(index));
    }

    /**
     * Adds the item at the beginning of the list
     */
    @Override
    public void addFirst(int item) {
        if (size > 0)
            addItemBefore(item, this.root);
        else
            addLast(item);
    }

    /**
     * Adds the item at the end of the list
     */
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

    /**
     * Adds the item at the end of the list
     */
    @Override
    public void add(int item) {
        addLast(item);
    }

    @Override
    public void addAll(Collection<Integer> c) {
        Integer[] elements = (Integer[]) c.toArray(new Integer[c.size()]);
        for (int element : elements) {
            add(element);
        }
    }

    /**
     * gets the item at the beginning of the list
     */
    @Override
    public int getFirst() {
        if (this.root == null)
            throw new NoSuchElementException();
        return this.root.getItem();

    }

    /**
     * gets the item at the end of the list
     */
    @Override
    public int getLast() {
        if (this.end == null)
            throw new NoSuchElementException();
        return this.end.getItem();
    }

    /**
     * gets the item at the index provided
     */
    @Override
    public int get(int index) {
        checkIndexInclusive(index);
        final Node node = getNode(index);
        return node.getItem();
    }

    /**
     * removes the item at the beginning
     */
    @Override
    public int removeFirst() {
        if (size == 0)
            throw new NoSuchElementException();
        return removeNode(this.root);
    }

    /**
     * removes the item at the end
     */
    @Override
    public int removeLast() {
        if (size == 0)
            throw new NoSuchElementException();
        return removeNode(this.end);
    }

    /**
     * removes the item at the index
     */
    @Override
    public int remove(int index) {
        if (size == 0)
            throw new NoSuchElementException();
        checkIndexInclusive(index);
        final Node node = getNode(index);
        return removeNode(node);
    }

    /**
     * removes the first occurrence of the item in the list and returns true. returns false, if the item is not found
     */
    @Override
    public boolean removeFirstOccurrence(int item) {
        for (Node i = this.root; i != null; i = i.getNext()) {
            if (i.getItem() == item) {
                removeNode(i);
                return true;
            }
        }
        return false;
    }

    /**
     * sets the item at the index
     */
    @Override
    public int set(int index, int item) {
        checkIndexInclusive(index);
        final Node node = getNode(index);
        node.setItem(item);
        return item;
    }

    /**
     * returns the size of the list
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * Adds the item before the node
     */
    private void addItemBefore(int item, Node node) {
        final Node prev = node.getPrev();
        final Node newNode = new Node(item, prev, node);
        node.addPrev(newNode);
        if (prev == null)
            this.root = newNode;
        else
            prev.addNext(newNode);
        size++;
    }

    /**
     * gets the node at the index if the index is valid
     */
    private Node getNode(int index) {
        Node i = this.root;
        for (int x = 0; x < index; x++)
            i = i.getNext();
        return i;
    }

    /**
     * removes the node from the list by adjusting the pointers at the previous and the next node
     */
    private int removeNode(Node node) {
        final Node prev = node.getPrev();
        final Node next = node.getNext();
        if (prev == null) {
            this.root = next;
        } else {
            prev.addNext(next);
            node.addPrev(null);
        }
        if (next == null) {
            this.end = prev;
        } else {
            next.addPrev(prev);
            node.addNext(null);
        }
        size--;
        return node.getItem();
    }

    /**
     * checks whether the index is a valid one for read/remove operations
     */
    private void checkIndexInclusive(int index) {
        if (!isValidIndex(index))
            throw new IndexOutOfBoundsException(indexDetails(index));
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
