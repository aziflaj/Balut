package com.aziflaj.balut.utils.db;

import com.aziflaj.balut.model.Player;

import java.sql.*;

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

    /**
     * Adds new score in the database
     *
     * @param winner The winner name or username
     * @param score  The score
     * @return 1 if the score is stored, otherwise 0
     * @throws SQLException
     */
    public int addNewScore(String winner, int score) throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement(BalutDbHelper.STORE_GAME);
        pstmt.setString(1, winner);
        pstmt.setInt(2, score);
        return pstmt.executeUpdate();
    }

    /**
     * Fetches the maximum score from the database
     *
     * @return The player with the maximum score
     * @throws SQLException
     */
    public Player getRecordman() throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(BalutDbHelper.GET_RECORDMAN);
        rs.next();
        Player recordman = new Player(rs.getString(1));
        recordman.addPoints(rs.getInt(2));
        return recordman;
    }
}
