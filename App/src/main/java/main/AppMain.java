package main;

import entity.Country;
import entity.Hotel;
import entity.Tour;
import entity.User;
import org.hibernate.Session;
import utils.HibernateSessionFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AppMain {
    public static void main(String[] args) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        session.beginTransaction();

        Country blr = new Country();
        Hotel rp = new Hotel();
        Tour tour = new Tour();
        User user = new User();

        List<Hotel> hotelList = new ArrayList<>();
        Set<Tour> tours = new HashSet<>();
        Set<Hotel> hotels = new HashSet<>();
        Set<Country> countries = new HashSet<>();
        Set<User> users = new HashSet<>();

        user.setTours(tours);
        user.setAge(25);
        user.setlName("Ruslan");
        user.setfName("Derkach");

        rp.setHotelName("Royal Plaza");
        rp.setReview("ok");
        rp.setCountry(blr);
        rp.setTours(tours);

        blr.addHotel(rp);
        blr.setCountry("BLR");
        blr.setHotels(hotelList);
        blr.setTours(tours);

        tour.setTourName("Minsk");
        tour.setCountries(countries);
        tour.setHotels(hotels);
        tour.setUsers(users);

        tours.add(tour);
        countries.add(blr);
        hotels.add(rp);
        hotelList.add(rp);

        session.save(user);
        session.save(tour);
        session.save(rp);
        session.save(blr);
        session.getTransaction().commit();
        session.close();

        user.listUser();
    }
}
