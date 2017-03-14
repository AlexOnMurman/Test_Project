<%--
  Created by IntelliJ IDEA.
  User: av.sitov
  Date: 10.03.2017
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>TestTask</title>
  </head>
  <body>
  <h3>CRUD-приложение "Список пользователей" для участия в стажировке JAVARUSH</h3>
  <br/>
  <h3>Краткое описание возможностей</h3>
      <ul>
          <li>Добавление, редактирование, удаление пользователей</li>
          <li>Фильтр по имени (ищется вхождение фрагмента в имя пользователя <b>like %фрагмент_для_поиска%</b>)</li>
          <li>Пейджинг при просмотре по 5 записей на страницу (если в режиме фильтра начать редактирование пользователя, то происходит возврат к странице, из которой был запущен фильтр)</li>
      </ul>

  <a href="<c:url value="/users/1"/>">User list</a>
  </body>
</html>
