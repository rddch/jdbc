package DAO;

import Entity.User;
import pool.ConnectionPool;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserImp implements EntityDAO<User> {

    private ConnectionPool cp = ConnectionPool.getInstance();

    @Override
    public void add(User user) {
        try {
            PreparedStatement preparedStatement = cp.getConnection().prepareStatement("INSERT INTO user (fname, lname, age) VALUES (?, ?, ?)");
            preparedStatement.setString(1, user.getfName());
            preparedStatement.setString(2, user.getlName());
            preparedStatement.setInt(3, user.getAge());

            System.out.println(preparedStatement.executeUpdate());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User read(long id) {
        User user = null;
        try {
            PreparedStatement preparedStatement = cp.getConnection().prepareStatement("SELECT * FROM user WHERE user_id = ?");
            preparedStatement.setLong(1, id);
            user = (User) preparedStatement.getResultSet().getObject((int)id);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> all() {
        List<User> user = null;
        try {
            Statement statement = cp.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user");


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(long id) {

    }
}
