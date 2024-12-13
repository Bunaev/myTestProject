
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<form class="form-horizontal">
    <fieldset>

        <!-- Form Name -->
        <legend>Регистрация</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="name">Введите имя: </label>
            <div class="col-md-4">
                <input id="name" name="name" type="text" placeholder="Enter your name" class="form-control input-md">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="login">Введите логин: </label>
            <div class="col-md-4">
                <input id="login" name="login" type="text" placeholder="Enter your login" class="form-control input-md">

            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="password">Введите пароль: </label>
            <div class="col-md-4">
                <input id="password" name="password" type="password" placeholder="Enter your password" class="form-control input-md">

            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="register"></label>
            <div class="col-md-4">
                </br>
                <button formmethod="post" id="register" name="register" class="btn btn-primary">Зарегистрироваться</button>
            </div>
        </div>

    </fieldset>
</form>
