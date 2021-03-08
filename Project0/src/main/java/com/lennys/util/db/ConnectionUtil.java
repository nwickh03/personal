package com.lennys.util.db;

import com.lennys.exception.DBException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    
    private static Connection connection;

    private ConnectionUtil() {}

    public static synchronized Connection getConnection() throws SQLException {
        if (connection == null) {

            String url = "jdbc:postgresql://lennydb.cxquhw2xbtzt.us-east-2.rds.amazonaws.com:5432/postgres";
            String username = "lenny";
            String password = "lll";

            connection = DriverManager.getConnection(url, username, password);

        }
        return connection;
    }

    public static synchronized void closeConnection() throws DBException{
        if (null != connection) {
            try {
                connection.close();
            }   catch (SQLException e)  {
                throw new DBException(e.getMessage());
            }
        }

    }
}
