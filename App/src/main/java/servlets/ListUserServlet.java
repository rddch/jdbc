package servlets;

import entity.User;

import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.util.List;


public class ListUserServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        List<User> users = new User().listUser();
        request.setAttribute("listUser", users);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/user/listUser.jsp");
        requestDispatcher.forward(request, response);
    }
}
