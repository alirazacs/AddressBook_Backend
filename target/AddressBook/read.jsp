<%--
  Created by IntelliJ IDEA.
  User: ALIRAZA
  Date: 8/11/2021
  Time: 12:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Address Records</title>
    </head>
    <body>
        <a href="${pageContext.request.contextPath}/showForm">
            Address new address
        </a>
        <br><br>

        <h2> Addresses List Here:</h2>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Email</th>
                <th>Gender</th>
                <th>City</th>
                <th>Action</th>
            </tr>
            <c:forEach var="temp" items="${listAddress}">
                <tr>
                    <td>${temp.id}</td>
                    <td>${temp.name}</td>
                    <td>${temp.email}</td>
                    <td>${temp.gender}</td>
                    <td>${temp.city}</td>
                    <td><a href="update/${temp.id}">Update</a> | <a
                            href="delete/${temp.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>

    </body>
</html>
