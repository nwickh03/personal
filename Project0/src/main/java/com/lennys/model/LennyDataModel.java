package com.lennys.model;

public abstract class LennyDataModel<T> implements Comparable<T>{
    @Override
    public abstract int compareTo(Object o);
}
