package com.lennys.dao;

import com.lennys.exception.DBException;
import com.lennys.model.people.User;
import com.lennys.util.LennyLinkedTreeSet;
import com.lennys.util.db.ConnectionUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUserDAO implements Dao<User,String> {


    @Override
    public void create(User user) throws DBException {

        String sql = "INSERT INTO lenny.\"User\" (\"Username\", \"Password\", \"PhoneNumber\", \"Email\", \"Type\")" +
                "VALUES(?,?,?,?,?)";

        try (PreparedStatement ps = ConnectionUtil.getConnection().prepareStatement(sql)){


            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getPhoneNumber());
            ps.setString(4,user.getEmail());
            ps.setInt(5,user.getType().ordinal());
            ps.executeUpdate();



        } catch (SQLException throwables) {
            throw new DBException(throwables.getMessage());
        }
    }

    @Override
    public User read(String id) throws DBException {

        String sql = "SELECT \"Username\", \"Password\", \"PhoneNumber\", \"Email\", \"Type\"" +
                "FROM lenny.\"User\" where \"Username\" = ?";
        try(PreparedStatement ps = ConnectionUtil.getConnection().prepareStatement(sql)) {


            ps.setString(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));

            } else rs.close();
            return null;


        }catch (SQLException e){
            throw new DBException(e.getMessage());
        }
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(String username) throws DBException {
        String sql = "DELETE FROM lenny.\"User\"" +
        "WHERE \"Username\"=?;";

        try(PreparedStatement ps =ConnectionUtil.getConnection().prepareStatement(sql)){
            ps.setString(1,username);
            ps.executeUpdate();

        }catch (SQLException e){
            throw new DBException(e.getMessage());
        }


    }

    @Override
    public LennyLinkedTreeSet<User> getAll() {
        return null;
    }
}
