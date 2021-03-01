package com.lennys.util;

import com.lennys.exception.DuplicateEntryException;

public abstract class LennyCollection<T>{
    private T t;

    protected int maxSize;

    public abstract boolean isEmpty();

    public abstract int size();

    abstract boolean contains(T t);

    public abstract void add(T t) throws DuplicateEntryException;

    public abstract void remove(T t) throws Exception;





}
