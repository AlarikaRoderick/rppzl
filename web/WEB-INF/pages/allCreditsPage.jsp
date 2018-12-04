<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Helen_Roderick
  Date: 12/4/18
  Time: 5:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Кредиты</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <a href="/enterClient">Назад</a>
    <form method="post">
        <table class="table table-sm">
            <thead>
            <th>ID</th>
            <th>Тип кредита</th>
            <th>Номер договора</th>
            <th>Валюта</th>
            <th>Дата начала</th>
            <th>Дата окончания</th>
            <th>Срок договора</th>
            <th>Сумма кредита</th>
            <th>Процент</th>
            <th>Текущий процент</th>
            <th>Действие</th>
            </thead>
            <tbody>
            <jsp:useBean id="credits" scope="request" type="java.util.List"/>
            <c:forEach var="credit" items="${credits}" varStatus="status">
                <tr>
                    <td>${credit.idCredit}</td>
                    <td>${credit.creditType}</td>
                    <td>${credit.contractNumber}</td>
                    <td>${credit.currencyType}</td>
                    <td>${credit.dateBegin}</td>
                    <td>${credit.dateEnd}</td>
                    <td>${credit.contractTerm}</td>
                    <td>${credit.creditSum}</td>
                    <td>${credit.creditPercent}</td>
                    <td>${credit.currentPercent}</td>
                    <td>
                        <button>Закрыть счет</button>
                   </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <button type="submit" name="closeBankDay">Завершить банковский день</button>
    </form>

</div>
тут будут кредиты
</body>
</html>
