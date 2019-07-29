package servlets;

import entity.Tour;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListTourServlet")
public class ListTourServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Tour> tours = new Tour().listTour();
        request.setAttribute("listTours", tours);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/tour/list.jsp");
        requestDispatcher.forward(request, response);
    }
}