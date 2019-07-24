package entity;

import javax.persistence.*;
import java.util.HashSet;
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
}
