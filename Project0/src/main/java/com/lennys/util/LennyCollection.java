package com.lennys.util;

import com.lennys.model.people.User;

import java.util.Collection;
import java.util.LinkedList;
import java.util.TreeSet;

public abstract class LennyCollection<T> implements Comparable{
    private T t;

    protected int maxSize;

    public abstract boolean isEmpty();

    public abstract int size();

    abstract <T> boolean Contains(T t);

    abstract void order();

    public abstract <T> T get(T t);

    public abstract <T> void add(T t) throws Exception;

    public abstract <T> void remove(T t) throws Exception;

    protected abstract <T extends Comparable> Node<T> prev();


}
