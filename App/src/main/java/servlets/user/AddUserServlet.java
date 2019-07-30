package servlets.user;

import entity.User;
import org.hibernate.Session;
import utils.HibernateSessionFactory;

import javax.servlet.RequestDispatcher;
import java.io.IOException;


public class AddUserServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        String lname = request.getParameter("lname");
        String fname = request.getParameter("fname");
        String age = request.getParameter("age");
        User user = new User();
        user.setfName(fname);
        user.setlName(lname);
        user.setlName(age);
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/user/addCountry.jsp");
        requestDispatcher.forward(request, response);
    }
}
