<jsp:useBean id="client" scope="request" class="model.Client"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <title>Кредит</title>
</head>
<body>
<div class="container">
    <a href="/clients">Вернуться на страницу всех клиентов</a>
    <form action="/credit/${client.id}" method="post" id="login-form">

        <div class="form-group">
            <label for="credit-type">Вид кредита</label>
            <select class="form-control" id="credit-type" name="creditType">
                <option value="dif">Дифференцированный</option>
                <option value="ne_dif">Не дифференцированный</option>
            </select>
        </div>

        <div class="form-group row">
            <label for="contract-number" class="col-sm-2 col-form-label">Номер договора</label>
            <div class="col-sm-10">
                <input required type="number" class="form-control" id="contract-number" name="contractNumber">
            </div>
        </div>

        <div class="form-group">
            <label for="currency-type">Валюта</label>
            <select class="form-control" id="currency-type" name="currencyType">
                <option value="BYN">BYN</option>
                <option value="RUB">RUB</option>
                <option value="USD">USD</option>
                <option value="EUR">EUR</option>
            </select>
        </div>

        <div class="form-group row">
            <label for="date-begin" class="col-sm-2 col-form-label">Дата начала кредитной программы</label>
            <div class="col-sm-10">
                <input required type="date" class="form-control" id="date-begin" name="dateBegin">
            </div>
        </div>

        <div class="form-group row">
            <label for="date-end" class="col-sm-2 col-form-label">Дата окончания кредитной программы</label>
            <div class="col-sm-10">
                <input required type="date" class="form-control" id="date-end" name="dateEnd">
            </div>
        </div>

        <div class="form-group row">
            <label for="contract-term" class="col-sm-2 col-form-label">Срок договора</label>
            <div class="col-sm-10">
                <input required type="number" class="form-control" id="contract-term" name="contractTerm">
            </div>
        </div>

        <div class="form-group row">
            <label for="credit-sum" class="col-sm-2 col-form-label">Сумма кредита</label>
            <div class="col-sm-10">
                <input required type="number" class="form-control" id="credit-sum" name="creditSum">
            </div>
        </div>

        <div class="form-group row">
            <label for="credit-percent" class="col-sm-2 col-form-label">Процент по кредиту</label>
            <div class="col-sm-10">
                <input required type="number" class="form-control" id="credit-percent" name="creditPercent" min="1" max="20">
                <!-- надо узнать максимальный процент -->
            </div>
        </div>

        <div class="form-group row">
            <div class="col-sm-10">
                <button type="submit" class="btn btn-primary">Сохранить</button>
            </div>
        </div>

    </form>
</div>
</body>
</html>
