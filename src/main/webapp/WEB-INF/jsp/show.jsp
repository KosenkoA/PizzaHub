<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <table>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>description</th>
        </tr>
        <table border="1">
            <c:forEach items="${pizza}" var="pizz">
                <tr>
                    <td>${pizz.id}</td>
                    <td>${pizz.name}</td>
                    <td>${pizz.description}</td>
                </tr>
            </c:forEach>
        </table>
    </table>
</div>
</body>
</html>