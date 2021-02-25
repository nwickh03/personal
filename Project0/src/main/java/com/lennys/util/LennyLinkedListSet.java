package com.lennys.util;

import com.lennys.model.people.User;
import com.lennys.util.inter.LSortable;

public class LennyLinkedListSet<T extends User> extends LennyCollection implements LSortable {

    private T t;
    Node<T> head, tail;
    private int currentSize = 0;

    public boolean isEmpty() {
        if(head == null) return true; else return false;
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    boolean Contains(Object o) {
        return false;
    }


    @Override
    void order() {

    }

    @Override
    public T get(Object o) {
        return null;
    }

    @Override
    public void add(Object o) throws Exception {
        innerAdd((T)o);

    }

    private void innerAdd(T t) {
        if(head == null){
            head= new Node<T>(null,t,null);
        }else if (tail == null){
            tail = new Node<T>(head,t,null);
        }

    }

    @Override
    public void remove(Object o) throws Exception {

    }

    @Override
    public void sort() {

    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
