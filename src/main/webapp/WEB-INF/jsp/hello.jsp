<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<div class="container">
    <table>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>description</th>
        </tr>
        <table border="1">
        <c:forEach items="${pizzas}" var="pizza">
            <tr>
                <td>${pizza.id}</td>
                <td>${pizza.name}</td>
                <td>${pizza.description}</td>
            </tr>
        </c:forEach>
        </table>
    </table>
</div>