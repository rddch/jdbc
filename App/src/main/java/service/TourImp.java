package service;

import dao.EntityDAO;
import entity.Tour;
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
        try (PreparedStatement preparedStatement = cp.getConnection().prepareStatement(
                "INSERT INTO  tour (tour_name, tour_id) VALUES (?, ?)"
        )) {
            preparedStatement.setString(1, tour.getTourName());
            preparedStatement.setLong(2, tour.getTourId());
            logger.info("Query OK, " +  preparedStatement.executeUpdate() + " row affected!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void read(long id) {
        try (PreparedStatement preparedStatement = cp.getConnection().prepareStatement("SELECT * FROM tour WHERE tour_id = ?")) {
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            resultSet.next();
            long tour_id = resultSet.getLong("tour_id");
            String tour_name = resultSet.getString("tour_name");
            wiew(tour_id, tour_name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void all() {
        try (Statement statement = cp.getConnection().createStatement();) {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM tour");
            while (resultSet.next()) {
                long tour_id = resultSet.getLong("tour_id");
                String tour_name = resultSet.getString("tour_name");
                wiew(tour_id, tour_name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Tour tour, long id) {
        try (PreparedStatement preparedStatement = cp.getConnection().prepareStatement("UPDATE tour SET tour_name = ? WHERE tour_id = ?")) {
            preparedStatement.setString(1, tour.getTourName());
            preparedStatement.setLong(2, id);
            logger.info("Query OK, " +  preparedStatement.executeUpdate() + " row affected!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(long id) {
        try (PreparedStatement preparedStatement = cp.getConnection().prepareStatement("DELETE FROM tour WHERE tour_id = ?");) {
            preparedStatement.setLong(1, id);
            logger.info("Query OK, " +  preparedStatement.executeUpdate() + " row affected!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void wiew(long tour_id, String tour_name) {
        logger.info(
                " country{ tour_id " + tour_id +
                        ", tour_name " + tour_name +
                        " }");
    }
}
