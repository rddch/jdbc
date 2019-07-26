package servlets;

import javax.servlet.RequestDispatcher;
import java.io.IOException;


public class ListServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/user/list.jsp");
        requestDispatcher.forward(request, response);
    }
}
