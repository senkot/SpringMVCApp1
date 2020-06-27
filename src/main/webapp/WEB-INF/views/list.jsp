<%@ page import="java.util.List" %>
<%--<%@ page import="app.entities.User" %>
  Created by IntelliJ IDEA.
  User: KOTLIS
  Date: 01.06.2020
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <style>
        table, th, td {
            border: 1px solid black;
            margin: 3px;
        }
    </style>
    <title>The List of Users</title>
</head>
<body>
    <div>
        <h1>List of users</h1>
    </div>

    <div>
        <div>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Country</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>

                <c:forEach var="user" items="${users}">

                <tr>
                    <td><c:out value="${user.id}" /></td>
                    <td><c:out value="${user.name}" /></td>
                    <td><c:out value="${user.email}" /></td>
                    <td><c:out value="${user.country}" /></td>
                    <td>
                        <a href='<c:url value="/edit?id=${user.id}" />'>EDIT</a>
                    </td>
                    <td>
                        <a href='<c:url value="/delete?id=${user.id}" />'>DEL</a>
                    </td>
                </tr>

                </c:forEach>

            </table>
        </div>
    </div>

    <div>
        <button style="margin: 3px" onclick="location.href='<c:url value="/"/>'">Back to main</button>
    </div>
</body>
</html>
