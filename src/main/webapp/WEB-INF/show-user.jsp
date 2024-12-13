
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Show user</title>
</head>
<div class="col-md-4">
    <c:if test="${sessionScope.id==requestScope.user.id}">
    <fieldset>
        <form class="form-horizontal" method="post">
        <legend>Данные пользователя: ${requestScope.user.name}</legend>
        <label style="display: block;float: left;width: 80px;height: 15px;">ID: </label>№${requestScope.user.id}
        </br>
        <label for="name" style="display: block;float: left;width: 80px;height: 15px;">Имя: </label>
        <input
                id="name"
                name="name"
                type="text"
                value="${requestScope.user.name}"
                placeholder="your login"
                class="form-control input-md"
                required="">
        </br>
        <label for="login" style="display: block;float: left;width: 80px;height: 15px;">Логин: </label>
        <input
                id="login"
                name="login"
                type="text"
                value="${requestScope.user.login}"
                placeholder="your login"
                class="form-control input-md"
                required="">
        </br>
        <label for="password" style="display: block;float: left;width: 80px;height: 15px;">Пароль: </label>
        <input
                id="password"
                name="password"
                type="text"
                value="${requestScope.user.password}"
                placeholder="your login"
                class="form-control input-md"
                required="">
        </br>
        <label for="role" style="display: block;float: left;width: 80px;height: 15px;">Роль: </label>
        <select id="role" name="role" class="form-control">
            <c:forEach var="role" items="${applicationScope.roles}">
                <option value="${role}" ${role==requestScope.user.role?"selected":""}>${role}</option>
            </c:forEach>
        </select>
        </br>
        </br>
        <button formmethod="post" id="save" name="save" value="save" class="btn btn-success" style="margin-left: 80px">Сохранить</button>
        </form>
    </fieldset>
    </c:if>
<c:if test="${sessionScope.id!=requestScope.user.id}">
<fieldset>
        <form class="form-horizontal" method="post">
            <legend>Данные пользователя: ${requestScope.user.name}</legend>
            <label style="display: block;float: left;width: 80px;height: 15px;">ID: </label>№${requestScope.user.id}
            </br>
            <label style="display: block;float: left;width: 80px;height: 15px;">Имя: </label>${requestScope.user.name}
            </br>
            <label style="display: block;float: left;width: 80px;height: 15px;">Логин: </label>${requestScope.user.login}
            </br>
            <label style="display: block;float: left;width: 80px;height: 15px;">Пароль: </label><i>Скрыто</i>
            </br>
            <label for="role" style="display: block;float: left;width: 80px;height: 15px;">Роль: </label>
            <select id="role" name="role" class="form-control">
                <c:forEach var="role" items="${applicationScope.roles}">
                    <option value="${role}" ${role==requestScope.user.role?"selected":""}>${role}</option>
                </c:forEach>
            </select>
            </br>
            </br>
            <button formmethod="post" id="save" name="save" value="save" class="btn btn-success" style="margin-left: 80px">Сохранить</button>
        </form>
    </fieldset>
</c:if>
</div>
</body>
</html>
