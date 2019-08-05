package pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPool {

    private static final String USER = "ruslan";
    private static final String PASSWORD = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/travel_agency";
    private Connection connection;

    private ConnectionPool() {

    }

    private static ConnectionPool instance = null;

    public static ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    public Connection getConnection() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);) {
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
