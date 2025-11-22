<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>

<html>
<head>
    <title>Report Page</title>
</head>
<body>

<h1 style="color:green;text-align:center">Actors Report Page</h1>

<c:if test="${not empty resultMap}">
    <h3 style="color:green;text-align:center">${resultMap}</h3>
</c:if>

<c:choose>
    <c:when test="${!empty actorDtos}">
        <table border="1" bgcolor="yellow" align="center">
            <tr>
                <th>aid</th>
                <th>name</th>
                <th>address</th>
                <th>category</th>
                <th>remuneration</th>
                <th>operations</th>
            </tr>

            <c:forEach var="dto" items="${actorDtos}">
                <tr>
                    <td>${dto.aid}</td>
                    <td>${dto.aname}</td>
                    <td>${dto.addrs}</td>
                    <td>${dto.category}</td>
                    <td>${dto.remuneration}</td>

                    <td>
                        <a href="${pageContext.request.contextPath}/edit?no=${dto.aid}">
                            <img src="${pageContext.request.contextPath}/images/edit.png" width="30px" height="30px" alt="edit">
                        </a>

                        &nbsp;&nbsp;&nbsp;

                        <a href="${pageContext.request.contextPath}/delete?no=${dto.aid}">
                            <img src="${pageContext.request.contextPath}/images/delete.png" width="30px" height="30px" alt="delete">
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:when>

    <c:otherwise>
        <h1 align="center">No actors found, please try again later.</h1>
    </c:otherwise>
</c:choose>

<br><br>

<div align="center">

    <a href="${pageContext.request.contextPath}/add">
        <img src="${pageContext.request.contextPath}/images/add.png" alt="add" width="80px" height="80px">
    </a>
    <br><br>

    <a href="${pageContext.request.contextPath}/">
        <img src="${pageContext.request.contextPath}/images/home.png" alt="home" width="80px" height="80px">
    </a>

</div>

</body>
</html>
