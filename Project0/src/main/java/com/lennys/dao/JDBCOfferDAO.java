package com.lennys.dao;

import com.lennys.exception.DBException;
import com.lennys.model.things.Offer;
import com.lennys.util.LennyLinkedTreeSet;
import com.lennys.util.db.ConnectionUtil;


import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCOfferDAO implements Dao<Offer, Integer>{
    @Override
    public void create(Offer offer) throws DBException {

        String sql = "insert into \"Offer\" (\"Vin\", total, downpayment, term, \"Username\") values(?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = ConnectionUtil.getConnection().prepareStatement(sql);
            ps.setInt(1,offer.getVin());
            ps.setDouble(2,offer.getTotal());
            ps.setDouble(3,offer.getDownPayment());
            ps.setInt(4,offer.getTerm());
            ps.setString(5, offer.getUsername());
            ps.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Offer read(Integer id) {
        return null;
    }

    @Override
    public void update(Offer offer) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public LennyLinkedTreeSet<Offer> getAll() {
        return null;
    }
}
