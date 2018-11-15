<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Helen_Roderick
  Date: 13.10.2018
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Clients</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<a href="/enterClient">Добавить клиента</a>
    <form method="post">
        <table class="table table-sm">
            <thead>
            <tr>
                <th>ФИО</th>
                <th>Номер паспорта</th>
                <th>E-mail</th>
                <th>Действие</th>
            </tr>
            </thead>
            <tbody>
            <jsp:useBean id="clients" scope="request" type="java.util.List"/>
            <c:forEach var="client" items="${clients}" varStatus="status">
                <tr>
                    <td>
                        ${client.id}
                        <a href="${pageContext.servletContext.contextPath}/clients/${client.id}">${client.lastName} ${client.firstName} ${client.patronymic}</a>
                    </td>
                    <td>
                        ${client.passportNumber}
                    </td>
                    <td>
                        ${client.email}
                    </td>
                    <td>
                        <button type="submit" name="delete" value="${client.id}">Удалить</button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </form>
</body>
</html>
