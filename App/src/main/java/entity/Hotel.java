package entity;

import org.hibernate.Session;
import utils.HibernateSessionFactory;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long hotelId;
    private String hotelName;
    private String review;
    @ManyToOne
    private Country country;
    @ManyToMany
    private Set<Tour> tours = new HashSet<>();

    public Hotel(String hotelName, String review, Country country, Set<Tour> tours) {
        this.hotelName = hotelName;
        this.review = review;
        this.country = country;
        this.tours = tours;
    }

    public Set<Tour> getTours() {
        return tours;
    }

    public void setTours(Set<Tour> tours) {
        this.tours = tours;
    }

    public Hotel() {
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public long getHotelId() {
        return hotelId;
    }

    public void setHotelId(long hotelId) {
        this.hotelId = hotelId;
    }

    public List<Hotel> listHotel() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        List<Hotel> result = session.createQuery("FROM entity.Hotel").list();
        session.getTransaction().commit();
        return result;
    }
    @Override
    public String toString() {
        return "Hotel{" +
                "hotelId=" + hotelId +
                ", hotelName='" + hotelName + '\'' +
                ", review='" + review + '\'' +
                ", country=" + country +
                ", tours=" + tours +
                '}';
    }
}
