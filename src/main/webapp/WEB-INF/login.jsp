<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>My Project</title>
</head>
<body>
<br/>
<form class="form-horizontal">
    <fieldset>
        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="login">Логин: </label>
            <div class="col-md-4">
                <input id="login" name="login" type="text" placeholder="Enter your login" class="form-control input-md">
            </div>
        </div>
        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="password">Пароль: </label>
            <div class="col-md-4">
                <input id="password" name="password" type="password" placeholder="Enter your password" class="form-control input-md">
            </div>
        </div>
        </br>
        <div class="form-group">
            <div class="col-md-8">
                <button formmethod="post" id="enter" name="enter" value="enter" class="btn btn-success">Войти</button>
            </div>
            <c:if test="${requestScope.authorized==false}">
            <i style="color: red">Неверный логин или пароль!</i>
                <a href="registration" style="font-style: italic">Зарегистрироваться</a>
            </c:if>
        </div>
    </fieldset>
</form>
</body>
</html>
