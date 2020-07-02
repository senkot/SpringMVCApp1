<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<div>
    <h1>Welcome!</h1>
</div>

<div>
    <div>
        <button onclick="location.href='<c:url value="/list"/>'">Users list</button>
        <button onclick="location.href='<c:url value="/add"/>'">Add user</button>
    </div>
</div>
</body>
</html>
