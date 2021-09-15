<%--
  Created by IntelliJ IDEA.
  User: ALIRAZA
  Date: 8/10/2021
  Time: 11:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Create Address</title>
    </head>

    <body style="text-align: center">
        <form:form modelAttribute="address" action="${pageContext.request.contextPath}/create" method="post">
            Name: <form:input path="name" value="${address.name}"/>
            <br> <br>

            Email:<form:input path="email" type="email" value="${address.email}"/>
            <br> <br>

            <form:radiobutton path="gender" value="male"
                              checked="${address.gender.equals('male')?'checked':'checked'}"/>Male
            <form:radiobutton path="gender" value="female" checked="${address.gender.equals('female')?'checked':''}"/>Female
            <br> <br>
            <form:select path="city">
                <c:forEach var="city" items="${address.cities}">

                    <form:option value="${city}" selected="${city.equals(address.city)?'selected':''}"/>${city}
                </c:forEach>

            </form:select>
            <br> <br>
            <input type="submit" value="submit">
        </form:form>


    </body>
</html>
