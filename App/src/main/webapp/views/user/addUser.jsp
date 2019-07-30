<%--
  Created by IntelliJ IDEA.
  User: ruslan
  Date: 26.7.19
  Time: 14.28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add user</title>
</head>
<body>

<%
    if (request.getAttribute("userName") != null) {
        out.println("<p>User '" + request.getAttribute("userName") + "' added</p>");
    }
%>
<form method="post">
    <label>Имя:
        <input type="text" name="fname"></br>
    </label>
    <label>Фамилия:
        <input type="text" name="lname"></br>
    </label>
    <label>Возраст:
        <input type="text" name="age"><br>
    </label>
    <button type="submit">Отправить</button>
</form>
<button onclick="location.href='/'">Назад</button>
</body>
</html>
