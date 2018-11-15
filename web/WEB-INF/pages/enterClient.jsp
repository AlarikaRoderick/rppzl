<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Helen_Roderick
  Date: 11.09.2018
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <title>Ввод данных</title>
</head>
<body>
<div class="container">
<header class="card-header"></header>
<a href="${pageContext.servletContext.contextPath}/clients">Просмотр базы клиентов</a>
    <br>
    <span>
        <c:if test="${param.suchClientExist != null}">
            Такой пользователь уже есть в БД!!!
        </c:if>
    </span>
    <br>
    <span>
        <c:if test="${param.suchPassportNumberExist}">
            Пользователь с таким номером паспорта уже существует в БД!!!
        </c:if>
    </span>
    <br>
    <span>
        <c:if test="${param.suchIdenticalNumberExist}">
            Пользователь с таким идентификационным номером уже существует в БД!!!
        </c:if>
    </span>
<form action="/enterClient" method="post" id="login-form">

    <div class="form-group row">
        <label for="first-name" class="col-sm-2 col-form-label">Имя</label>
        <div class="col-sm-10">
            <input required type="text" class="form-control" id="first-name" name="firstName" placeholder="Имя" minlength="2" maxlength="20">
            <div class="invalid-enter">Имя должно содержать от 2 до 20 непробельных символов</div>
        </div>
    </div>

    <div class="form-group row">
        <label for="last-name" class="col-sm-2 col-form-label">Фамилия</label>
        <div class="col-sm-10">
            <input required type="text" class="form-control" id="last-name" name="lastName" placeholder="Фамилия" minlength="2" maxlength="20">
        </div>
    </div>

    <div class="form-group row">
        <label for="patronymic" class="col-sm-2 col-form-label">Отчество</label>
        <div class="col-sm-10">
            <input required type="text" class="form-control" id="patronymic" name="patronymic" placeholder="Отчество" minlength="2" maxlength="20">
        </div>
    </div>

    <div class="form-group row">
        <label for="birth-date" class="col-sm-2 col-form-label">Дата рождения</label>
        <div class="col-sm-10">
            <input required type="date" class="form-control" id="birth-date" name="birthDate">
        </div>
    </div>

    <fieldset class="form-group">
        <div class="row">
            <legend class="col-form-label col-sm-2 pt-0">Ваш пол</legend>
            <div class="col-sm-10">
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gender" id="man" value="Мужской" checked>
                    <label class="form-check-label" for="man">
                        Мужской пол
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gender" id="woman" value="Женский">
                    <label class="form-check-label" for="woman">
                        Женский пол
                    </label>
                </div>
            </div>
        </div>
    </fieldset>

    <div class="form-group row">
        <label for="passport-series" class="col-sm-2 col-form-label">Серия паспорта</label>
        <div class="col-sm-10">
            <input required type="text" class="form-control" id="passport-series" name="passportSeries" placeholder="Серия паспорта" minlength="2" maxlength="2">
        </div>
    </div>

    <div class="form-group row">
        <label for="passport-number" class="col-sm-2 col-form-label">Номер паспорта</label>
        <div class="col-sm-10">
            <input required type="text" class="form-control" id="passport-number" name="passportNumber" placeholder="Номер паспорта" pattern="^[A-Z]{2}[0-9]{7}$">
        </div>
    </div>

    <div class="form-group row">
        <label for="passport-issue" class="col-sm-2 col-form-label">Кем выдан паспорт</label>
        <div class="col-sm-10">
            <input required type="text" class="form-control" id="passport-issue" name="passportIssue" placeholder="Кем выдан">
        </div>
    </div>

    <div class="form-group row">
        <label for="date-issue" class="col-sm-2 col-form-label">Дата выдачи паспорта</label>
        <div class="col-sm-10">
            <input required type="date" class="form-control" id="date-issue" name="dateIssue">
        </div>
    </div>

    <div class="form-group row">
        <label for="identical-number" class="col-sm-2 col-form-label">Идентификационный номер</label>
        <div class="col-sm-10">
            <input required type="text" class="form-control" id="identical-number" name="identicalNumber">
        </div>
    </div>

    <div class="form-group row">
        <label for="birth-place" class="col-sm-2 col-form-label">Место рождения</label>
        <div class="col-sm-10">
            <input required type="text" class="form-control" id="birth-place" name="birthPlace" placeholder="Место рождения">
        </div>
    </div>

    <div class="form-group">
        <label for="living-city">Выберите город проживания</label>
        <select class="form-control" id="living-city" name="livingCity">
            <option value="Минск">Минск</option>
            <option value="Гомель">Гомель</option>
            <option value="Гродно">Гродно</option>
            <option value="Брест">Брест</option>
            <option value="Витебск">Витебск</option>
            <option value="Могилёв">Могилёв</option>
        </select>
    </div>

    <div class="form-group row">
        <label for="phone-home-number" class="col-sm-2 col-form-label">Номер домашнего телефона</label>
        <div class="col-sm-10">
            <input required type="text" class="form-control" id="phone-home-number" name="phoneHomeNumber" pattern="^\+[0-9]{12}$">
        </div>
    </div>

    <div class="form-group row">
        <label for="phone-number" class="col-sm-2 col-form-label">Номер мобильного телефона</label>
        <div class="col-sm-10">
            <input required type="text" class="form-control" id="phone-number" name="phoneNumber" pattern="^\+[0-9]{12}$">
        </div>
    </div>

    <div class="form-group row">
        <label for="email" class="col-sm-2 col-form-label">E-mail</label>
        <div class="col-sm-10">
            <input required type="email" class="form-control" id="email" name="email">
        </div>
    </div>

    <div class="form-group">
        <label for="marital-status">Выберите семейное положение</label>
        <select class="form-control" id="marital-status" name="maritalStatus">
            <option value="Замужем/женат">Замужем/женат</option>
            <option value="В гражданском браке">В гражданском браке</option>
            <option value="Не замужем/не женат">Не замужем/не женат</option>
            <option value="Помолвлена/помолвлен">Помолвлена/помолвлен</option>
        </select>
    </div>

    <div class="form-group">
        <label for="citizenship">Выберите гражданство</label>
        <select class="form-control" id="citizenship" name="citizenship">
            <option value="Белорусское">Белорусское</option>
            <option value="Российское">Российское</option>
            <option value="Украинское">Украинское</option>
            <option value="Французское">Французское</option>
            <option value="Американское">Американское</option>
        </select>
    </div>

    <div class="form-group">
        <label for="disability">Степень инвалидности</label>
        <select class="form-control" id="disability" name="disability">
            <option value="Нет инвалидности">Нет инвалидности</option>
            <option value="1 степень">1 степень</option>
            <option value="2 степень">2 степень</option>
            <option value="3 степень">3 степень</option>
            <option value="4 степень">4 степень</option>
        </select>
    </div>

    <fieldset class="form-group">
        <div class="row">
            <legend class="col-form-label col-sm-2 pt-0">Пенсионер</legend>
            <div class="col-sm-10">
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="pensioner" id="true-pensioner" value="Да" checked>
                    <label class="form-check-label" for="true-pensioner">
                        Да
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="pensioner" id="false-pensioner" value="Нет">
                    <label class="form-check-label" for="false-pensioner">
                        Нет
                    </label>
                </div>
            </div>
        </div>
    </fieldset>

    <div class="form-group row">
        <label for="monthly-income" class="col-sm-2 col-form-label">Ежемесячный доход</label>
        <div class="col-sm-10">
            <input required type="number" class="form-control" id="monthly-income" name="monthlyIncome" min="0">
        </div>
    </div>

    <fieldset class="form-group">
        <div class="row">
            <legend class="col-form-label col-sm-2 pt-0">Служба в армии</legend>
            <div class="col-sm-10">
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="military" id="true-military" value="Да" checked>
                    <label class="form-check-label" for="true-military">
                        Да
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="military" id="false-military" value="Нет">
                    <label class="form-check-label" for="false-military">
                        Нет
                    </label>
                </div>
            </div>
        </div>
    </fieldset>

    <div class="form-group row">
        <div class="col-sm-10">
            <button type="submit" class="btn btn-primary">Сохранить</button>
        </div>
    </div>

</form>
<footer></footer>
</div>
</body>
</html>
