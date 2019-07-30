package servlets;

import entity.Tour;
import org.hibernate.Session;
import utils.HibernateSessionFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddTourServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        String tourName = request.getParameter("tourName");
        Tour tour = new Tour();
        tour.setTourName(tourName);
        session.save(tour);
        session.getTransaction().commit();
        session.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/tour/addTour.jsp");
        requestDispatcher.forward(request, response);
    }
}
