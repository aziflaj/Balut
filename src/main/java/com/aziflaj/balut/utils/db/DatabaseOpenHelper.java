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

    /**
     * Opens the connection with the SQLite database. The constructor is
     * protected because there should be only one instance of this class,
     * making it a Singleton
     */
    protected DatabaseOpenHelper() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:balut.db");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the instance of the class and creates it if it's not
     * yet created, and also creates the database schema if it is not
     * yet created
     *
     * @return The connection instance of the database
     * @throws SQLException if any error occurs while creating the schema
     */
    public static DatabaseOpenHelper getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseOpenHelper();
            BalutDbHelper.createDb();
        }
        return instance;
    }

    /**
     * Runs an update statement in the database
     *
     * @param sql The SQL statement that should be run
     * @return 1 if the statement is run correctly, 0 otherwise
     * @throws SQLException if any error occurs while running the statement
     */
    public int update(String sql) throws SQLException {
        Statement statement = getInstance().connection.createStatement();
        return statement.executeUpdate(sql);
    }

    // TODO: insert method for new players and for new games

}
