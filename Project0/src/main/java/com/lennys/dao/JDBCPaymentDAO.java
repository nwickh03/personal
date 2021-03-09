package com.lennys.dao;

import com.lennys.exception.DBException;
import com.lennys.model.things.Payment;
import com.lennys.util.LennyLinkedTreeSet;
import com.lennys.util.db.ConnectionUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCPaymentDAO implements Dao<Payment, Integer> {
    @Override
    public void create(Payment payment) throws DBException {

    }

    @Override
    public Payment read(Integer id) throws DBException {
        String sql = "SELECT\"Balance\", \"Amount\", \"RemainingTerms\"\n" +
                "FROM lenny.\"Payment\" where \"Id\" = ?;";
        try(PreparedStatement ps = ConnectionUtil.getConnection().prepareStatement(sql)){
            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Payment(rs.getDouble(1),rs.getDouble(2),rs.getInt(3));
            }
        } catch (SQLException throwables) {
            throw new DBException(throwables.getMessage());
        }
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
