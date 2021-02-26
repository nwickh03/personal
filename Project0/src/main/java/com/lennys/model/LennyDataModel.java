package com.lennys.model;

import java.io.Serializable;

public abstract class LennyDataModel<T> implements Comparable<T>, Serializable {
    @Override
    public abstract int compareTo(Object o);
}
