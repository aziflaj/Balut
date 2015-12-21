package com.aziflaj.balut.utils.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * A helper class for accessing the Database and handling low-level
 * database functionality, such as reading or updating records
 */
public class DatabaseOpenHelper {
    private static DatabaseOpenHelper instance = null;
    private Connection connection;

    protected DatabaseOpenHelper() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:balut.db");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static DatabaseOpenHelper getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseOpenHelper();
            BalutDbHelper.createDb();
        }
        return instance;
    }

    public int update(String sql) throws SQLException {
        Statement statement = getInstance().connection.createStatement();
        return statement.executeUpdate(sql);
    }

}
