package com.aziflaj.balut.utils.db;

import java.sql.SQLException;

/**
 * Database helper class
 */
public class BalutDbHelper {
    static final String CREATE_TABLE_PLAYER = "CREATE TABLE IF NOT EXISTS player ( " +
            "id INTEGER PRIMARY KEY, " +
            "first_name TEXT NOT NULL, " +
            "last_name TEXT NOT NULL, " +
            "age INTEGER NOT NULL " +
            ");";

    static final String CREATE_TABLE_GAME_PLAYER = "CREATE TABLE IF NOT EXISTS game_players ( " +
            "id INTEGER NOT NULL, " +
            // "game_id INTEGER NOT NULL, " +
            "player_id INTEGER NOT NULL, " +
            "score INTEGER NOT NULL, " +
            "FOREIGN KEY (game_id) REFERENCES game (id), " +
            "FOREIGN KEY (player_id) REFERENCES player (id) " +
            ");";

    // TODO: delete
    static final String CREATE_TABLE_GAME = "CREATE TABLE IF NOT EXISTS game ( " +
            "id INTEGER PRIMARY KEY, " +
            "winner_id INTEGER NOT NULL, " +
//            "score INTEGER NOT NULL, " +
            "FOREIGN KEY (winner_id) REFERENCES player (id) " +
            ");";

    /**
     * One-time running method for creating the schema of the database
     *
     * @return The number of tables created
     * @throws SQLException if some error occurs while creating the schema
     */
    public static int createDb() throws SQLException {
        int result = 0;
        result += DatabaseOpenHelper.getInstance().update(CREATE_TABLE_PLAYER);
        result += DatabaseOpenHelper.getInstance().update(CREATE_TABLE_GAME);
        result += DatabaseOpenHelper.getInstance().update(CREATE_TABLE_GAME_PLAYER);
        return result;
    }
}
