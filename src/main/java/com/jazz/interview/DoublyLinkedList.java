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
        checkIndexInclusive(index);
        final Node node = getNode(index);
        return node.getItem();
    }

    @Override
    public int removeFirst() {
        if (size == 0)
            throw new NoSuchElementException();
        int i = this.root.getItem();
        size--;
        if(this.root.getNext() != null)
            this.root.getNext().addPrev(null);
        else
            this.end = null;
        this.root = this.root.getNext();
        return i;
    }

    @Override
    public int removeLast() {
        if (size == 0)
            throw new NoSuchElementException();
        int i = this.end.getItem();
        size--;
        if(this.end.getPrev() != null)
            this.end.getPrev().addNext(null);
        else
            this.root = null;
        this.end = this.end.getPrev();
        return i;
    }

    @Override
    public int remove(int index) {
        checkIndexInclusive(index);
        final Node node = getNode(index);
        return removeNode(node);
    }

    @Override
    public boolean removeFirstOccurrence(int item) {
        for (Node i = this.root;i != null; i = i.getNext()){
            if(i.getItem() == item){
                removeNode(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public int set(int index, int item) {
        checkIndexInclusive(index);
        final Node node = getNode(index);
        node.setItem(item);
        return item;
    }

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

    private int removeNode(Node node){
        final Node prev = node.getPrev();
        final Node next = node.getNext();
        if(prev == null) {
            this.root = next;
        }else{
            prev.addNext(next);
            node.addPrev(null);
        }
        if(next == null){
            this.end = prev;
        }else{
            next.addPrev(prev);
            node.addNext(null);
        }
        size--;
        return node.getItem();
    }

    private void checkIndexInclusive(int index){
        if(!isValidIndex(index))
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
