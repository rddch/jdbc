package pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MyConnectionPool {

    private static final String USER = "ruslan";
    private static final String PASSWORD = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/travel_agency";
    private static final int CAPACITY = 20;
    public static List<Connection> pool = new ArrayList<>(CAPACITY);

    private MyConnectionPool() {
        for (int i = 0; i < 20; i++) {
            pool.add(new MyConnectionPool().getConnection());
        }
    }

    private static MyConnectionPool instance = null;

    public static MyConnectionPool getInstance() {
        if (instance == null) {
            instance = new MyConnectionPool();

        }
        return instance;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
