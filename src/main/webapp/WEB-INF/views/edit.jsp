<%--
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
    <link rel="stylesheet" href="styles/w3.css">
    <title>Add new User</title>
</head>
<body>
<div>
    <h1>Editing User</h1>
</div>
<div>
    <div>
        <form method="post">
            <div>
                <h2>Add user:</h2>
            </div>
            <label>Name:
                <input type="text" value="<c:out value='${user.name}' />" name="name" value=""><br />
            </label>
            <label>Email
                <input type="email" value="<c:out value='${user.email}' />" name="email"><br />
            </label>
            <label>Country
                <input type="country" value="<c:out value='${user.country}' />" name="country"><br />
            </label>
            <button type="submit">Edit</button>
        </form>
    </div>
</div>

<div>
    <button onclick="location.href='/'">Back to main</button>
</div>
</body>
</html>
