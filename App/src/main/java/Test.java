import DAO.*;
import Entity.Country;
import Entity.Hotel;
import Entity.Tour;
import Entity.User;
import pool.MyConnectionPool;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {

    User rita = new User("Rita", "Vasilieva", 25, 1);
    User viktor = new User("Viktor", "Toporov", 44, 2);
    Country blr = new Country("BLR", 1);
    Country ukr = new Country("UKR", 2);
    Country ger = new Country("GER",3);
    Hotel roylPlaza = new Hotel("Royl Plaza", "cool!", 1, 2);
    Hotel goldOfSee = new Hotel("Gold of See", "not bad!",2,2);
    Tour minsk = new Tour("Minsk", 1);
    Tour kiev = new Tour("Kiev", 2);

//    new UserImp().add(rita);
//    new UserImp().add(viktor);
//    new CountryImp().add(blr);
//    new CountryImp().add(ukr);
//    new CountryImp().add(ger);
//
//    new HotelImp().add(roylPlaza, blr);
//    new HotelImp().add(goldOfSee, ukr);
//
//    new TourImp().add(minsk);
//    new TourImp().add(kiev);
//
//    new CountryTour().add(blr,minsk);
//    new CountryTour().add(ukr,kiev);
//
//    new TourHotel().add(minsk, roylPlaza);
//    new TourHotel().add(kiev, goldOfSee);
//
//    new UserTour().add(viktor, minsk);
//    new UserTour().add(rita,kiev);

    }
}
