<jsp:useBean id="deposit" scope="request" class="model.Deposit"/>
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
    <title>Депозиты</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <a href="/enterClient">Назад</a>
    <form method="post">
        <table class="table table-sm">
            <thead>
            <th>ID</th>
            <th>Тип депозита</th>
            <th>Номер договора</th>
            <th>Валюта</th>
            <th>Дата начала</th>
            <th>Дата окончания</th>
            <th>Срок договора</th>
            <th>Сумма вклада</th>
            <th>Процент</th>
            <th>Текущий процент</th>
            <th>Действие</th>
            </thead>
            <tbody>
            <jsp:useBean id="deposits" scope="request" type="java.util.List"/>
            <c:forEach var="deposit" items="${deposits}" varStatus="status">
                <tr>
                    <td>${deposit.idDeposit}</td>
                    <td>${deposit.depositType}</td>
                    <td>${deposit.contactNumber}</td>
                    <td>${deposit.currencyType}</td>
                    <td>${deposit.dateBegin}</td>
                    <td>${deposit.dateEnd}</td>
                    <td>${deposit.contractTerm}</td>
                    <td>${deposit.depositSum}</td>
                    <td>${deposit.depositPercent}</td>
                    <td>${deposit.currentPercent}</td>
                    <td><c:if test="${deposit.depositType.toString() eq 'otz'}">
                        <button>Закрыть счет</button>
                    </c:if></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <button type="submit" name="closeBankDay">Завершить банковский день</button>
    </form>
    <input type="number" name="fond" value="${deposit.fondSum}" disabled>

</div>
тут будут депозиты
</body>
</html>
