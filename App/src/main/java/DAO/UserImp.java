package DAO;

import Entity.User;
import pool.ConnectionPool;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class UserImp implements EntityDAO<User> {

    private ConnectionPool cp = ConnectionPool.getInstance();
    Logger logger = Logger.getLogger(UserImp.class.getName());

    @Override
    public void add(User user) {
        PreparedStatement preparedStatement  = null;
        try {
            preparedStatement = cp.getConnection().prepareStatement("INSERT INTO user (fname, lname, age) VALUES (?, ?, ?)");
            preparedStatement.setString(1, user.getfName());
            preparedStatement.setString(2, user.getlName());
            preparedStatement.setInt(3, user.getAge());
            logger.info("Query OK, " +  preparedStatement.executeUpdate() + " row affected!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void read(long id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = cp.getConnection().prepareStatement("SELECT * FROM user WHERE user_id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            resultSet.next();
            int user_id = resultSet.getInt("user_id");
            int age = resultSet.getInt("age");
            String fname = resultSet.getString("fname");
            String lname = resultSet.getString("lname");
            wiew(user_id, fname, lname, age);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void all() {
        Statement statement = null;
        try {
            statement = cp.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user");
            while (resultSet.next()) {
                long user_id = resultSet.getLong("user_id");
                String fname = resultSet.getString("fname");
                String lname = resultSet.getString("lname");
                int age = resultSet.getInt("age");
                wiew(user_id, fname, lname, age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(User user, long id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = cp.getConnection().prepareStatement("UPDATE user SET fname = ?, lname = ?, age = ? WHERE user_id = ?");
            preparedStatement.setString(1, user.getfName());
            preparedStatement.setString(2, user.getlName());
            preparedStatement.setInt(3, user.getAge());
            preparedStatement.setLong(4, id);
            logger.info("Query OK, " +  preparedStatement.executeUpdate() + " row affected!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(long id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = cp.getConnection().prepareStatement("DELETE FROM user WHERE user_id = ?");
            preparedStatement.setLong(1, id);
            logger.info("Query OK, " +  preparedStatement.executeUpdate() + " row affected!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    void wiew(long user_id, String fname, String lname, int age) {
        logger.info(
                " user{ user_id " + user_id +
                ", fname " + fname +
                ", lname " + lname +
                ", age " + age +
                " }");
    }
}
