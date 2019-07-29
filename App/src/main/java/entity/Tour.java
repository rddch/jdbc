package entity;

import org.hibernate.Session;
import utils.HibernateSessionFactory;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tourId;
    private String tourName;
    @ManyToMany(mappedBy = "tours")
    private Set<Country> countries = new HashSet<>();
    @ManyToMany(mappedBy = "tours")
    private Set<Hotel> hotels = new HashSet<>();
    @ManyToMany(mappedBy = "tours")
    private Set<User> users = new HashSet<>();

    public Tour(String tourName, Set<Country> countries, Set<Hotel> hotels, Set<User> users) {
        this.tourName = tourName;
        this.countries = countries;
        this.hotels = hotels;
        this.users = users;
    }

    public Tour() {
    }

    public Set<Country> getCountries() {
        return countries;
    }

    public void setCountries(Set<Country> countries) {
        this.countries = countries;
    }

    public Set<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(Set<Hotel> hotels) {
        this.hotels = hotels;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public long getTourId() {
        return tourId;
    }

    public void setTourId(long tourId) {
        this.tourId = tourId;
    }

    public List<Tour> listTour() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        List<Tour> result = session.createQuery("FROM entity.Tour").list();
        session.getTransaction().commit();
        return result;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "tourId=" + tourId +
                ", tourName='" + tourName + '\'' +
                ", countries=" + countries +
                ", hotels=" + hotels +
                ", users=" + users +
                '}';
    }
}
