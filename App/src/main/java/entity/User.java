package entity;

import org.hibernate.Session;
import utils.HibernateSessionFactory;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private String fName;
    private String lName;
    private int age;
    @ManyToMany
    private Set<Tour> tours = new HashSet<>();

    public User(String fName, String lName, int age, long userId, Set<Tour> tours ) {
        this.fName = fName;
        this.lName = lName;
        this.age = age;
        this.userId = userId;
        this.tours = tours;
    }

    public User() {

    }

    public Set<Tour> getTours() {
        return tours;
    }

    public void setTours(Set<Tour> tours) {
        this.tours = tours;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", age=" + age +
                ", tours=" + tours +
                '}';
    }

    public List<User> listUser() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        List<User> result = session.createQuery("FROM entity.User").list();
        session.getTransaction().commit();
        return result;
    }
}
