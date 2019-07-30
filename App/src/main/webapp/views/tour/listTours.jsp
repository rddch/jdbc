<%@ page import="entity.Tour" %>
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
<%
    List<Tour> tours = (List<Tour>) request.getAttribute("listTours");
    if (tours != null && !tours.isEmpty()) {
        for (Object o : tours) {
            out.print("<li>" + o.toString() + "/li");
        }
    }
%>

</body>
</html>
