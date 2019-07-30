package servlets;

import entity.Hotel;
import org.hibernate.Session;
import utils.HibernateSessionFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddHotelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        String hotelName = request.getParameter("hotelName");
        String review = request.getParameter("review");
        Hotel hotel = new Hotel();
        hotel.setHotelName(hotelName);
        hotel.setReview(review);
        session.save(hotel);
        session.getTransaction().commit();
        session.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/hotel/addHotel.jsp");
        requestDispatcher.forward(request, response);
    }
}
