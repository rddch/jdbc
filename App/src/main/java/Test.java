import DAO.UserImp;
import Entity.User;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
        User user = new User();
        user.setUserId(4);
        user.setfName("Ruslan");
        user.setlName("Derkach");
        user.setAge(25);
        new UserImp().add(user);
        System.out.println(new UserImp().all());
    }
}
