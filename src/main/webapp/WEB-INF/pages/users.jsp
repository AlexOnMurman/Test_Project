<%--
  Created by IntelliJ IDEA.
  User: av.sitov
  Date: 10.03.2017
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <title>Users Page</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

    </style>


</head>

<h1 align="center">Список пользователей</h1>

<c:if test="${!empty listUsers}">
    <table class="tg" align="center">
        <tr>
            <th width="80">Идентификатор</th>
            <th width="200">Имя пользователя</th>
            <th width="120">Возраст</th>
            <th width="150">Признак администратора</th>
            <th width="200">Дата изменения</th>
            <th width="80">Редактировать</th>
            <th width="80">Удалить</th>
        </tr>
        <c:forEach items="${listUsers}" var="user">
            <tr>
                <td>${user.userId}</td>
                <td>${user.userName}</td>
                <td>${user.userAge}</td>
                <td>${user.isUserAdmin}</td>
                <td><fmt:formatDate pattern="dd/MM/yyyy HH:mm:ss" value="${user.userCreatedDate}" /></td>
                <td><a href="<c:url value='/edit/${user.userId}'/>">Редактировать</a></td>
                <td><a href="<c:url value='/remove/${user.userId}'/>">Удалить</a></td>
            </tr>
        </c:forEach>
    </table>

    <!-- Пейждинг-->
 <table align = "center">
    <tr><td>
    <c:forEach begin="1" end="${count}" var="val">
        <c:url var="pageURL" value="/users/${val}" />
        <a href="${pageURL}">-${val}-</a>&nbsp;&nbsp;
    </c:forEach>
    </td></tr>
 </table>

</c:if>

<table align="center">
<tr valign="top"><td>
<h2>Добавление/редактирование</h2>
<c:url var="addAction" value="/users/add"/>
<form:form action="${addAction}" commandName="user">
    <table class="tg">
        <c:if test="${user.userId > 0}">
            <tr>
                <td>
                    <form:label path="userId">
                        <spring:message text="Идентификатор"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="userId" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="userId"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="userName">
                    <spring:message text="Имя пользователя"/>
                </form:label>
            </td>
            <td>
                <form:input path="userName"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="userAge">
                    <spring:message text="Возраст"/>
                </form:label>
            </td>
            <td>
                <form:input path="userAge"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="isUserAdmin">
                    <spring:message text="Признак администратора"/>
                </form:label>
            </td>
            <td>
                <form:checkbox  path="isUserAdmin"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${user.userId > 0}">
                    <input type="submit"
                           value="<spring:message text="Редактировать"/>"/>
                </c:if>
                <c:if test="${user.userId == 0}">
                    <input type="submit"
                           value="<spring:message text="Добавить"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</td>
<td>
    <h2>Фильтр пользователей</h2>
    <c:url var="filterAction" value="/users/filter"/>
    <form:form action="${filterAction}" commandName="user">
        <c:if test="${!empty filter}">
            <form:input path="userName" disabled="true"/>
            <input type="submit"
                   value="<spring:message text="Сбросить"/>"/>
        </c:if>
        <c:if test="${empty filter}">
            <form:input path="userName"/>
            <input type="submit"
                   value="<spring:message text="Фильтровать"/>"/>
        </c:if>
    </form:form>
</td>
</tr>
</table>

</body>
</html>
