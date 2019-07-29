package servlets;

import entity.Hotel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListHotelServlet")
public class ListHotelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Hotel> hotels = new Hotel().listHotel();
        request.setAttribute("listHotels", hotels);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/hotel/list.jsp");
        requestDispatcher.forward(request, response);
    }
}
