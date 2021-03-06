package DAO;

import Entity.Tour;
import Entity.User;
import pool.ConnectionPool;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

public class UserTour {

    private ConnectionPool cp = ConnectionPool.getInstance();
    Logger logger = Logger.getLogger(UserImp.class.getName());


    public void add(User user, Tour tour) throws SQLException {
        PreparedStatement preparedStatement  = null;
        try {
            preparedStatement = cp.getConnection().prepareStatement(
                    "INSERT INTO  user_tour (user_id, tour_id) VALUES (?, ?)");
            preparedStatement.setLong(1, user.getUserId());
            preparedStatement.setLong(2, tour.getTourId());
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
}
