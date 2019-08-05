package entity;

public class User {

    private String fName;
    private String lName;
    private int age;
    private long userId;

    public User(String fName, String lName, int age, long userId) {
        this.fName = fName;
        this.lName = lName;
        this.age = age;
        this.userId = userId;
    }

    public User() {

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
