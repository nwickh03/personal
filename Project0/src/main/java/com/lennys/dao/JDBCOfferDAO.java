package com.lennys.dao;

import com.lennys.exception.DBException;
import com.lennys.model.things.Offer;
import com.lennys.util.LennyLinkedTreeSet;
import com.lennys.util.db.ConnectionUtil;


import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            throw new DBException(throwables.getMessage());
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

    public LennyLinkedTreeSet<Offer> getByVin(Integer vin) throws DBException {
        {
            String sql = "SELECT * " +
                    "FROM lenny.\"Offer\" where \"Vin\" = ?;";
            try(PreparedStatement ps = ConnectionUtil.getConnection().prepareStatement(sql)){

                LennyLinkedTreeSet<Offer> results = new LennyLinkedTreeSet<>();
                ps.setInt(1,vin);
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    Offer offer;
                    offer = new Offer(rs.getInt(1),
                            rs.getInt(2),
                            rs.getDouble(3),
                            rs.getInt(4),
                            rs.getInt(5),
                            rs.getString(6),rs.getInt(7));

                    results.add(offer);
                }
                return results;
            } catch (SQLException throwables) {
                throw new DBException(throwables.getMessage());
            }
        }
    }

    public void accept(Offer o) throws DBException {
        String sql = "CALL lenny.accept_offer(?,?);";
        try(CallableStatement ps = ConnectionUtil.getConnection().prepareCall(sql)){

            ps.setInt(1, o.getId());
            ps.setInt(2,o.getVin());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throw new DBException(throwables.getMessage());
        }


    }

    public void reject(Offer o) throws DBException {
        String sql = "UPDATE lenny.\"Offer\" + \"SET \"Status\"=2\"" +
                "WHERE \"OfferId\"=?;";
        try(PreparedStatement ps = ConnectionUtil.getConnection().prepareStatement(sql)){
            ps.setInt(1,o.getId());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throw new DBException();
        }

    }
}
