package service;

import dao.EntityDAO;
import entity.Country;
import pool.ConnectionPool;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class CountryImp implements EntityDAO<Country> {

    private ConnectionPool cp = ConnectionPool.getInstance();
    Logger logger = Logger.getLogger(UserImp.class.getName());

    @Override
    public void add(Country country) {
        try (PreparedStatement preparedStatement  = cp.getConnection().prepareStatement("INSERT INTO  country (country, country_id) VALUES (?, ?)")) {
            preparedStatement.setString(1, country.getCountry());
            preparedStatement.setLong(2, country.getCountryId());
            logger.info("Query OK, " +  preparedStatement.executeUpdate() + " row affected!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void read(long id) {
        try (PreparedStatement preparedStatement = cp.getConnection().prepareStatement("SELECT * FROM country WHERE country_id = ?")) {
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            resultSet.next();
            long country_id = resultSet.getLong("country_id");
            String country = resultSet.getString("country");
            wiew(country_id, country);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void all() {
        try(Statement statement = cp.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM country");
            while (resultSet.next()) {
                long country_id = resultSet.getLong("country_id");
                String country = resultSet.getString("country");
                wiew(country_id, country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Country country, long id) {
        try (PreparedStatement preparedStatement = cp.getConnection().prepareStatement("UPDATE country SET country = ? WHERE country_id = ?")) {
            preparedStatement.setString(1, country.getCountry());
            preparedStatement.setLong(2, id);
            logger.info("Query OK, " +  preparedStatement.executeUpdate() + " row affected!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(long id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = cp.getConnection().prepareStatement(
                "UPDATE hotel SET country_id = null WHERE country_id = ?");

            preparedStatement.setLong(1, id);
            logger.info("Query OK, " +  preparedStatement.executeUpdate() + " row affected!");

            preparedStatement = cp.getConnection().prepareStatement(
                    "DELETE FROM hotel WHERE country_id = ?"
            );
            preparedStatement.setLong(1, id);
            logger.info("Query OK, " +  preparedStatement.executeUpdate() + " row affected!");

            preparedStatement = cp.getConnection().prepareStatement(
                    "DELETE FROM country_tour WHERE country_id = ?"
            );
            preparedStatement.setLong(1, id);
            logger.info("Query OK, " +  preparedStatement.executeUpdate() + " row affected!");

            preparedStatement = cp.getConnection().prepareStatement(
                    "DELETE FROM country WHERE country_id = ?"
            );
            preparedStatement.setLong(1, id);
            logger.info("Query OK, " +  preparedStatement.executeUpdate() + " row affected!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void wiew(long country_id, String country) {
        logger.info(
                " country{ country_id " + country_id +
                        ", country " + country +
                        " }");
    }
}
