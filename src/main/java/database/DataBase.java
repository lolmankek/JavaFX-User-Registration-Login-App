package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {

    private static final String URL = "jdbc:h2:file:~/PojectZ-DataBase";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    /**
     * Returns a connection to the H2 database.
     * @return
     * @throws SQLException
     */
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /**
     * The SQL command creates the users table if it does not already exist.
     */
    public static void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "first_name VARCHAR(100)," +
                "last_name VARCHAR(100)," +
                "password VARCHAR(100)," +
                "sex VARCHAR(10))";


         // try-with-resources opens a connection and creates a SQL statement
         // Executes a CREATE TABLE SQL query
         // In case of an error, prints the call stack
        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
