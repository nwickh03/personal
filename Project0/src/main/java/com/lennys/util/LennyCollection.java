package com.lennys.util;

import com.lennys.exception.DuplicateEntryException;

public abstract class LennyCollection<T> implements Comparable{
    private T t;

    protected int maxSize;

    public abstract boolean isEmpty();

    public abstract int size();

    abstract <T> boolean Contains(T t);

    public abstract <T> T get(T t);

    public abstract <T> void add(T t) throws Exception, DuplicateEntryException;

    public abstract <T> void remove(T t) throws Exception;



}
