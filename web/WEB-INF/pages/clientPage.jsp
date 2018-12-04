<jsp:useBean id="client" scope="request" class="model.Client"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Client page</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<a href="/clients">Вернуться к списку всех клиентов</a>
<a href="/deposit/${client.id}">Заключить депозитный договор</a>
<c:if test="${not empty param.successUpdate}">
    Обновление прошло успешно
</c:if>
<form method="post">
    <table class="table table-sm">
        <tr>
            <div class="input-group">
                <td>
                    <div class="input-group-prepend">
                        <span class="input-group-text">ФИО</span>
                    </div>
                </td>
                <td>
                    <input hidden name="idClient" value="${client.id}">
                    <input type="text" name="lastName" class="form-control" value="${client.lastName}">
                    <input type="text" name="firstName" aria-label="First name" class="form-control" value="${client.firstName}">
                    <input type="text" name="patronymic" aria-label="patronymic" class="form-control" value="${client.patronymic}">
                </td>
            </div>
        </tr>
        <tr>
            <div class="input-group">
                <td>
                    <div class="input-group-prepend">
                        <span class="input-group-text">Дата рождения</span>
                    </div>
                </td>
                <td>
                    <input type="date" name="birthDate" aria-label="date" class="form-control" value="${client.birthDate}">
                </td>
            </div>
        </tr>
        <tr>
            <div class="input-group">
                <td>
                    <div class="input-group-prepend">
                        <span class="input-group-text">Пол</span>
                    </div>
                </td>
                <td>
                    <select class="form-control" id="gender" name="gender">
                        <option value="${client.gender}" selected>${client.gender}</option>
                        <option value="Женский">Женский</option>
                        <option value="Мужской">Мужской</option>
                    </select>
                </td>
            </div>
        </tr>
        <tr>
            <div class="input-group">
                <td>
                    <div class="input-group-prepend">
                        <span class="input-group-text">Серия паспорта</span>
                    </div>
                </td>
                <td>
                    <input type="text" name="passportSeries" aria-label="passport-number" class="form-control" value="${client.passportSeries}">
                </td>
            </div>
        </tr>
        <tr>
            <div class="input-group">
                <td>
                    <div class="input-group-prepend">
                        <span class="input-group-text">Номер паспорта</span>
                    </div>
                </td>
                <td>
                    <input type="text" name="passportNumber" aria-label="passport-number" class="form-control" value="${client.passportNumber}">
                </td>
            </div>
        </tr>
        <tr>
            <div class="input-group">
                <td>
                    <div class="input-group-prepend">
                        <span class="input-group-text">Дата выдачи паспорта</span>
                    </div>
                </td>
                <td>
                    <input type="date" name="dateIssue" aria-label="date-issue" class="form-control" value="${client.dateIssue}">
                </td>
            </div>
        </tr>
        <tr>
            <div class="input-group">
                <td>
                    <div class="input-group-prepend">
                        <span class="input-group-text">Кем выдан паспорт</span>
                    </div>
                </td>
                <td>
                    <input type="text" name="passportIssue" aria-label="passport-issue" class="form-control" value="${client.passportIssue}">
                </td>
            </div>
        </tr>
        <tr>
            <div class="input-group">
                <td>
                    <div class="input-group-prepend">
                        <span class="input-group-text">Идентификационный номер</span>
                    </div>
                </td>
                <td>
                    <input type="text" name="identicalNumber" aria-label="identical-number" class="form-control" value="${client.identicalNumber}">
                </td>
            </div>
        </tr>
        <tr>
            <div class="input-group">
                <td>
                    <div class="input-group-prepend">
                        <span class="input-group-text">Место рождения</span>
                    </div>
                </td>
                <td>
                    <input type="text" name="birthPlace" aria-label="birth-place" class="form-control" value="${client.birthPlace}">
                </td>
            </div>
        </tr>
        <tr>
            <div class="input-group">
                <td>
                    <div class="input-group-prepend">
                        <span class="input-group-text">Место проживания</span>
                    </div>
                </td>
                <td>
                    <select class="form-control" id="living-city" name="livingCity">
                        <option value="${client.livingCity}" selected>${client.livingCity}</option>
                        <option value="Минск">Минск</option>
                        <option value="Гомель">Гомель</option>
                        <option value="Гродно">Гродно</option>
                        <option value="Брест">Брест</option>
                        <option value="Витебск">Витебск</option>
                        <option value="Могилёв">Могилёв</option>
                    </select>
                </td>
            </div>
        </tr>
        <tr>
            <div class="input-group">
                <td>
                    <div class="input-group-prepend">
                        <span class="input-group-text">Домашний телефон</span>
                    </div>
                </td>
                <td>
                    <input type="text" name="phoneHomeNumber" aria-label="phone-home-number" class="form-control" value="${client.phoneHomeNumber}">
                </td>
            </div>
        </tr>
        <tr>
            <div class="input-group">
                <td>
                    <div class="input-group-prepend">
                        <span class="input-group-text">Мобильный телефон</span>
                    </div>
                </td>
                <td>
                    <input type="text" name="phoneNumber" aria-label="phone-number" class="form-control" value="${client.phoneNumber}">
                </td>
            </div>
        </tr>
        <tr>
            <div class="input-group">
                <td>
                    <div class="input-group-prepend">
                        <span class="input-group-text">E-mail</span>
                    </div>
                </td>
                <td>
                    <input type="email" name="email" aria-label="email" class="form-control" value="${client.email}">
                </td>
            </div>
        </tr>
        <tr>
            <div class="input-group">
                <td>
                    <div class="input-group-prepend">
                        <span class="input-group-text">Семейное положение</span>
                    </div>
                </td>
                <td>
                    <select class="form-control" id="marital-status" name="maritalStatus">
                        <option value="${client.maritalStatus}" selected>${client.maritalStatus}</option>
                        <option value="Замужем/женат">Замужем/женат</option>
                        <option value="В гражданском браке">В гражданском браке</option>
                        <option value="Не замужем/не женат">Не замужем/не женат</option>
                        <option value="Помолвлена/помолвлен">Помолвлена/помолвлен</option>
                    </select>
                </td>
            </div>
        </tr>
        <tr>
            <div class="input-group">
                <td>
                    <div class="input-group-prepend">
                        <span class="input-group-text">Гражданство</span>
                    </div>
                </td>
                <td>
                    <select class="form-control" id="citizenship" name="citizenship">
                        <option value="${client.citizenship}" selected>${client.citizenship}</option>
                        <option value="Белорусское">Белорусское</option>
                        <option value="Российское">Российское</option>
                        <option value="Украинское">Украинское</option>
                        <option value="Французское">Французское</option>
                        <option value="Американское">Американское</option>
                    </select>
                </td>
            </div>
        </tr>
        <tr>
            <div class="input-group">
                <td>
                    <div class="input-group-prepend">
                        <span class="input-group-text">Инвалидность</span>
                    </div>
                </td>
                <td>
                    <select class="form-control" id="disability" name="disability">
                        <option value="${client.disability}" selected>${client.disability}</option>
                        <option value="Нет инвалидности">Нет инвалидности</option>
                        <option value="1 степень">1 степень</option>
                        <option value="2 степень">2 степень</option>
                        <option value="3 степень">3 степень</option>
                        <option value="4 степень">4 степень</option>
                    </select>
                </td>
            </div>
        </tr>
        <tr>
            <div class="input-group">
                <td>
                    <div class="input-group-prepend">
                        <span class="input-group-text">Пенсионер</span>
                    </div>
                </td>
                <td>
                    <select class="form-control" id="pensioner" name="pensioner">
                        <option value="${client.pensioner}" selected>${client.pensioner}</option>
                        <option value="Да">Да</option>
                        <option value="Нет">Нет</option>
                    </select>
                </td>
            </div>
        </tr>
        <tr>
            <div class="input-group">
                <td>
                    <div class="input-group-prepend">
                        <span class="input-group-text">Ежемесячный доход</span>
                    </div>
                </td>
                <td>
                    <input type="text" name="monthlyIncome" aria-label="monthly-income" class="form-control" value="${client.monthlyIncome}">
                </td>
            </div>
        </tr>
        <tr>
            <div class="input-group">
                <td>
                    <div class="input-group-prepend">
                        <span class="input-group-text">Служба в армии</span>
                    </div>
                </td>
                <td>
                    <select class="form-control" id="military" name="military">
                        <option value="${client.military}" selected>${client.military}</option>
                        <option value="Да">Да</option>
                        <option value="Нет">Нет</option>
                    </select>
                </td>
            </div>
        </tr>
    </table>
    <button name="update" value="${client.id}">Обновить данные</button>
</form>
</body>
</html>
