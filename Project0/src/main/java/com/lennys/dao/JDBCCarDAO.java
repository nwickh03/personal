package com.lennys.dao;

import com.lennys.exception.DBException;
import com.lennys.model.things.Car;
import com.lennys.util.LennyLinkedTreeSet;
import com.lennys.util.db.ConnectionUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCCarDAO implements Dao<Car, Integer> {
    @Override
    public void create(Car car) throws DBException {
        String sql = "INSERT INTO lenny.\"Car\"" +
                "(\"Owner\", \"Vin\", \"Year\", \"Make\", \"Model\", \"CurrentPayment\")" +
                "VALUES(? ,? ,? ,? ,? ,? )";

        try(PreparedStatement ps = ConnectionUtil.getConnection().prepareStatement(sql)) {

            ps.setString(1,car.getOwner());
            ps.setInt(2,car.getVin());
            ps.setInt(3,car.getYear());
            ps.setString(4,car.getMake());
            ps.setString(5,car.getModel());
            ps.setObject(6,null);
            ps.executeUpdate();


        } catch(SQLException e){
            throw new DBException(e.getMessage());
        }


    }

    @Override
    public Car read(Integer id) throws DBException {
        String sql = "SELECT \"Owner\", \"Vin\", \"Year\", \"Make\", \"Model\", \"CurrentPayment\"" +
                "FROM lenny.\"Car\" where \"Vin\" = ?;";
        try(PreparedStatement ps = ConnectionUtil.getConnection().prepareStatement(sql)){

            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return new Car(rs.getString(1),rs.getInt(2),
                        rs.getInt(3),rs.getString(4),
                        rs.getString(5),rs.getInt(6));

            } else rs.close();
            return null;
        }catch (SQLException e){
            throw new DBException(e.getMessage());
        }
    }

    @Override
    public void update(Car car) throws DBException {

    }

    @Override
    public void delete(Integer id) throws DBException {

        String sql = "DELETE FROM lenny.\"Car\" " +
        "WHERE \"Vin\"=?;";

        try(PreparedStatement ps = ConnectionUtil.getConnection().prepareStatement(sql)) {

            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throw new DBException(throwables.getMessage());
        }


    }

    @Override
    public LennyLinkedTreeSet<Car> getAll() {
        return null;
    }

    public LennyLinkedTreeSet<Car> getLotByOwner(String username) throws DBException {
        String sql = "SELECT * " +
                "FROM lenny.\"Car\" where \"Owner\" = ?;";
        try(PreparedStatement ps = ConnectionUtil.getConnection().prepareStatement(sql)){

            LennyLinkedTreeSet<Car> results = new LennyLinkedTreeSet<>();
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Car car;
                car = new Car(rs.getString(1),rs.getInt(2),
                        rs.getInt(3),rs.getString(4),
                        rs.getString(5),rs.getInt(6));

                results.add(car);
            }
            return results;
        } catch (SQLException throwables) {
            throw new DBException(throwables.getMessage());
        }
    }

    public LennyLinkedTreeSet<Car> getCarsNotOwned() throws DBException {
        String sql = "SELECT * " +
                "FROM lenny.\"Car\" where \"Owner\" != ?;";
        try(PreparedStatement ps = ConnectionUtil.getConnection().prepareStatement(sql)){

            LennyLinkedTreeSet<Car> results = new LennyLinkedTreeSet<>();
            ps.setString(1,"lenny");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Car car;
                car = new Car(rs.getString(1),rs.getInt(2),
                        rs.getInt(3),rs.getString(4),
                        rs.getString(5),rs.getInt(6));

                results.add(car);
            }
            return results;
        } catch (SQLException throwables) {
            throw new DBException(throwables.getMessage());
        }
    }
}
