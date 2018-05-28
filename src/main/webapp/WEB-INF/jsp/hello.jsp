<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ include file="header.jsp" %>


<!DOCTYPE html>
<html>
<head>
    <title>Hello, Dude</title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
        th, td {
            padding: 15px;
        }
    </style>
</head>
<body>


<div class="container">
    <table>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>description</th>
        </tr>
            <c:forEach items="${pizzas}" var="pizza">
                <tr>
                    <td>${pizza.id}</td>
                    <td>${pizza.name}</td>
                    <td>${pizza.description}</td>
                </tr>
            </c:forEach>
    </table>
</div>


</body>
</html>