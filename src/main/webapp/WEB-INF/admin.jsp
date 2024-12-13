<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head>
    <title>Admin panel</title>
</head>
<body id="adminBody">
<br/>
<form class="form-horizontal">
    <button formmethod="post" id="allUsers" name="allUsers" value="allUsers" class="btn btn-success">Показать всех пользователей</button>
    </br>
<c:if test="${requestScope.users!=null}">
    <c:forEach var="user" items="${requestScope.users}">
        </br>
        <a href="show-user?id=${user.id}">${user.id} - ${user.name}</a>
        </br>
    </c:forEach>
</c:if>
</form>
</body>
</html>