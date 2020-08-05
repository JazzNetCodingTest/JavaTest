package com.jazz.interview;

abstract class AbstractSequenceList {

    public abstract void add(int index, int item);

    public abstract void addFirst(int item);

    public abstract void addLast(int item);

    public abstract void add(int item);

    public abstract int getFirst();

    public abstract int getLast();

    public abstract int get(int index);

//    public abstract int removeFirst();
//
//    public abstract int removeLast();
//
//    public abstract int remove(int index);
//
//    public abstract int removeFirstOccurrence(int item);

    public abstract int set(int index, int item);

    //TODO: size and toArray

    public abstract int getSize();


}
