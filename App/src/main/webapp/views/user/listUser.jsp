<%@ page import="java.util.List" %>
<%@ page import="entity.User" %>

Created by IntelliJ IDEA.
  User: ruslan
  Date: 26.7.19
  Time: 14.29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
</head>
<body>
<h1> Список пользователей </h1>
<%
    List<User> users = (List<User>) request.getAttribute("listUser");
    if (users != null && !users.isEmpty()) {
        for(Object o: users) {
            out.print("<li>" + o.toString() + "</li>");
        }
    }
%>
<button onclick="location.href='/'">Назад</button>
</body>
</html>
