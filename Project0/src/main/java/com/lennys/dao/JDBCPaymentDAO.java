package com.lennys.dao;

import com.lennys.exception.DBException;
import com.lennys.model.things.Payment;
import com.lennys.util.LennyLinkedTreeSet;

public class JDBCPaymentDAO implements Dao<Payment, Integer> {
    @Override
    public void create(Payment payment) throws DBException {

    }

    @Override
    public Payment read(Integer id) throws DBException {
        return null;
    }

    @Override
    public void update(Payment payment) throws DBException {

    }

    @Override
    public void delete(Integer integer) throws DBException {

    }

    @Override
    public LennyLinkedTreeSet<Payment> getAll() {
        return null;
    }
}
