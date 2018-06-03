<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>

<html>
<head>
    <title>Information about this dish</title>
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
            <th>picture</th>
        </tr>
        <c:forEach items="${pizza}" var="pizz">
            <div class="card-deck">
                <tr>
                    <td>${pizz.id}</td>
                    <td>${pizz.name}</td>
                    <td>${pizz.description}</td>
                    <td><img src="${pizz.picture}" alt="${pizz.description}" width="500" height="377"></td>

                </tr>
            </div>
        </c:forEach>
    </table>
</div>
</body>
</html>