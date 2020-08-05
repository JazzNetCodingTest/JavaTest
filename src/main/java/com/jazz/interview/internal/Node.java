package com.jazz.interview.internal;

public class Node {
    private int item;
    private Node prev;
    private Node next;

    public Node(Integer item, Node prev, Node next) {
        this.item = item;
        this.prev = prev;
        this.next = next;
    }

    public int getItem() {
        return item;
    }

    public Node getPrev() {
        return prev;
    }

    public Node getNext() {
        return next;
    }

    public void addPrev(Node node) {
        this.prev = node;
    }

    public void addNext(Node node) {
        this.next = node;
    }

    public void setItem(int item){
        this.item = item;
    }


}
