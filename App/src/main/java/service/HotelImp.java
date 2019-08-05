package service;

import dao.EntityDAO;
import entity.Country;
import entity.Hotel;
import pool.ConnectionPool;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public final class HotelImp implements EntityDAO<Hotel> {

    private ConnectionPool cp = ConnectionPool.getInstance();
    Logger logger = Logger.getLogger(UserImp.class.getName());

    public void add(Hotel hotel, Country country) {
        try (PreparedStatement preparedStatement = cp.getConnection().prepareStatement(
                "INSERT INTO  hotel (hotel_name, review, hotel_id, country_id) VALUES (?, ?, ?, ?)"
        )) {
            preparedStatement.setString(1, hotel.getHotelName());
            preparedStatement.setString(2, hotel.getReview());
            preparedStatement.setLong(3, hotel.getHotelId());
            preparedStatement.setLong(4, country.getCountryId());
            logger.info("Query OK, " +  preparedStatement.executeUpdate() + " row affected!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void add(Hotel hotel) throws SQLException {
    }
    @Override
    public void read(long id) {
        try ( PreparedStatement preparedStatement = cp.getConnection().prepareStatement("SELECT * FROM hotel WHERE hotel_id = ?");) {
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            resultSet.next();
            long hotel_id = resultSet.getLong("hotel_id");
            String hotel_name = resultSet.getString("hotel_name");
            String review = resultSet.getString("review");
            wiew(hotel_id, hotel_name, review);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void all() {
        try (Statement    statement = cp.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM hotel");
            while (resultSet.next()) {
                long hotel_id = resultSet.getLong("hotel_id");
                String hotel_name = resultSet.getString("hotel_name");
                String review = resultSet.getString("review");
                wiew(hotel_id, hotel_name, review);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Hotel hotel, long id) {
        try (PreparedStatement preparedStatement = cp.getConnection().prepareStatement(
                "UPDATE hotel SET hotel_name = ?, review = ? WHERE hotel_id = ?"
        )) {
            preparedStatement.setString(1, hotel.getHotelName());
            preparedStatement.setString(2, hotel.getReview());
            preparedStatement.setLong(3, id);
            logger.info("Query OK, " +  preparedStatement.executeUpdate() + " row affected!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(long id) {
        try (PreparedStatement preparedStatement = cp.getConnection().prepareStatement("DELETE FROM hotel WHERE hotel_id = ?");) {
            preparedStatement.setLong(1, id);
            logger.info("Query OK, " +  preparedStatement.executeUpdate() + " row affected!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void wiew(long hotel_id, String hotel_name, String review) {
        logger.info(
                " hotel{ hotel_id " + hotel_id +
                        ", hotel_name " + hotel_name +
                        ", review " + review +
                        " }");
    }
}
