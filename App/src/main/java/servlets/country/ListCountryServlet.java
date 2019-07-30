package servlets.country;

import entity.Country;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListCountryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Country> countries = new Country().listCountry();
        request.setAttribute("listCountries", countries);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/country/listCountries.jsp");
        requestDispatcher.forward(request, response);
    }
}
