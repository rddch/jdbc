<%@ page import="entity.User" %>
<%@ page import="java.util.List" %><%--
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
    List<User> users = (List<User>) request.getAttribute("listUsers");
    if (users != null && !users.isEmpty()) {
        for (Object o : users) {
            out.print("<li>" + o.toString() + "/li");
        }
    }
%>
</body>
</html>
