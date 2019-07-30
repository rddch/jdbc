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
    <title>Добавить отель</title>
</head>
<body>
<form method="post">
    <label>Название отеля:
        <input type="text" name="hotelName"></br>
    </label>
    <label>Отзывы:
        <input type="text" name="review"></br>
    </label>
    <button type="submit">Отправить</button>
</form>
<button onclick="location.href='/'">Назад</button>
</body>
</html>
