package entity;

import org.hibernate.Session;
import utils.HibernateSessionFactory;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long countryId;
    private String country;
    @OneToMany(mappedBy = "country")
    private List<Hotel> hotels = new ArrayList<>();
    @ManyToMany
    private Set<Tour> tours = new HashSet<>();

    public Country(String country, List<Hotel> hotels, Set<Tour> tours) {
        this.country = country;
        this.hotels = hotels;
        this.tours = tours;
    }

    public Country() {
    }

    public List<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    public Set<Tour> getTours() {
        return tours;
    }

    public void setTours(Set<Tour> tours) {
        this.tours = tours;
    }

    public void addHotel(Hotel hotel) {
        this.hotels.add(hotel);
        hotel.setCountry(this);
    }
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getCountryId() {
        return countryId;
    }

    public void setCountryId(long countryId) {
        this.countryId = countryId;
    }

    public List<Country> listCountry() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        List<Country> result = session.createQuery("FROM entity.Country").list();
        session.getTransaction().commit();
        return result;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryId=" + countryId +
                ", country='" + country + '\'' +
                ", hotels=" + hotels +
                ", tours=" + tours +
                '}';
    }
}
