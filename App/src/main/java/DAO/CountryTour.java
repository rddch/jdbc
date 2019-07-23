package DAO;

import Entity.Country;
import Entity.Tour;
import pool.MyConnectionPool;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class CountryTour {

    private MyConnectionPool cp = MyConnectionPool.getInstance();
    Logger logger = Logger.getLogger(UserImp.class.getName());


    public void add(Country country, Tour tour) throws SQLException {
        PreparedStatement preparedStatement  = null;
        try {
            preparedStatement = cp.getConnection().prepareStatement(
                    "INSERT INTO  country_tour (country_id, tour_id) VALUES (?, ?)"
            );
            preparedStatement.setLong(1, country.getCountryId());
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

    public void read(long id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = cp.getConnection().prepareStatement(
                    "SELECT c.country, t.tour_name FROM country c " +
                       "INNER JOIN tour t ON c.country_id = t.tour_id " +
                       "WHERE country_id = ?"
            );
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            resultSet.next();
            String country = resultSet.getString("country");
            String tour_name = resultSet.getString("tour_name");
            wiew(tour_name, country);
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

    public void all() {
        Statement statement = null;
        try {
            statement = cp.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT c.country, t.tour_name FROM country c " +
                                                            "INNER JOIN tour t ON c.country_id = t.tour_id"
            );
            while (resultSet.next()) {
                String tout_name = resultSet.getString("tour_name");
                String country = resultSet.getString("country");
                wiew(tout_name, country);
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



    public void delete(long id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = cp.getConnection().prepareStatement(
                    "DELETE FROM country_tour WHERE country_id = ? OR tour_id = ?"
            );
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

    void wiew(String tour_name, String country) {
        logger.info(
                " информация о туре { тур " + tour_name +
                        ", в страну " + country +
                        " }");
    }

}
