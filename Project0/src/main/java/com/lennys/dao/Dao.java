package com.lennys.dao;

import com.lennys.exception.DBException;
import com.lennys.util.LennyLinkedTreeSet;

import java.sql.Connection;
import java.util.Optional;

public interface Dao<T extends Comparable<T>,K> {

    void create(T t) throws DBException;

    T read(K id) throws DBException;

    void update(T t) throws DBException;

    void delete(K k) throws DBException;

    LennyLinkedTreeSet<T> getAll();
}
