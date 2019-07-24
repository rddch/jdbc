package dao_jdbc;

import entity.Hotel;
import entity.Tour;
import pool.MyConnectionPool;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

public class TourHotel {

    private MyConnectionPool cp = MyConnectionPool.getInstance();
    Logger logger = Logger.getLogger(UserImp.class.getName());


    public void add(Tour tour, Hotel hotel) throws SQLException {
        PreparedStatement preparedStatement  = null;
        try {
            preparedStatement = cp.getConnection().prepareStatement(
                    "INSERT INTO  tour_hotel (tour_id, hotel_id) VALUES (?, ?)"
            );
            preparedStatement.setLong(1, tour.getTourId());
            preparedStatement.setLong(2, hotel.getHotelId());
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
