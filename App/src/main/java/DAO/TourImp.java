package DAO;

import Entity.Tour;
import pool.ConnectionPool;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class TourImp implements EntityDAO<Tour> {

    private ConnectionPool cp = ConnectionPool.getInstance();
    Logger logger = Logger.getLogger(UserImp.class.getName());

    @Override
    public void add(Tour tour) {
        PreparedStatement preparedStatement  = null;
        try {
            preparedStatement = cp.getConnection().prepareStatement("INSERT INTO  tour (tour_name) VALUES (?)");
            preparedStatement.setString(1, tour.getTourName());
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
            preparedStatement = cp.getConnection().prepareStatement("SELECT * FROM tour WHERE tour_id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            resultSet.next();
            long tour_id = resultSet.getLong("tour_id");
            String tour_name = resultSet.getString("tour_name");
            wiew(tour_id, tour_name);
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
            ResultSet resultSet = statement.executeQuery("SELECT * FROM tour");
            while (resultSet.next()) {
                long tour_id = resultSet.getLong("tour_id");
                String tour_name = resultSet.getString("tour_name");
                wiew(tour_id, tour_name);
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
    public void update(Tour tour, long id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = cp.getConnection().prepareStatement("UPDATE tour SET tour_name = ? WHERE tour_id = ?");
            preparedStatement.setString(1, tour.getTourName());
            preparedStatement.setLong(2, id);
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
            preparedStatement = cp.getConnection().prepareStatement("DELETE FROM tour WHERE tour_id = ?");
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

    void wiew(long tour_id, String tour_name) {
        logger.info(
                " country{ tour_id " + tour_id +
                        ", tour_name " + tour_name +
                        " }");
    }
}
