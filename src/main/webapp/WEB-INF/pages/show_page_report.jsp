<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>

<html>
<head>
    <title>Paginated Report Page</title>
    <style>
        .pagination-link {
            padding: 5px 10px;
            margin: 0 2px;
            border: 1px solid blue;
            text-decoration: none;
            color: blue;
        }
        .pagination-link.active {
            background-color: lightblue;
            font-weight: bold;
        }
    </style>
</head>
<body>

<h1 style="color:green;text-align:center">Actors Paginated Report</h1>

<c:if test="${not empty resultMap}">
    <h3 style="color:green;text-align:center">${resultMap}</h3>
</c:if>

<c:choose>
    <%-- Check if the page has content (pageData.content is not empty) --%>
    <c:when test="${!empty pageData.content}">
        <h4 align="center">
            Total Records: ${pageData.totalElements} |
            Total Pages: ${pageData.totalPages} |
            Current Page: ${pageData.number + 1}
        </h4>

        <table border="1" bgcolor="yellow" align="center">
            <tr>
                <th>aid</th>
                <th>name</th>
                <th>address</th>
                <th>category</th>
                <th>remuneration</th>
                <th>operations</th>
            </tr>

                <%-- Iterate over the content of the Page object --%>
            <c:forEach var="dto" items="${pageData.content}">
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

        <br>

        <%-- Pagination Navigation Links --%>
        <div align="center">

                <%-- Previous Page Link --%>
            <c:if test="${!pageData.first}">
                <a class="pagination-link" href="${pageContext.request.contextPath}/page_report?page=${pageData.number - 1}&size=${pageData.size}&sort=${pageable.sort}">
                    &lt;&lt; Previous
                </a>
            </c:if>

                <%-- Page Number Links (Shows a range for better navigation) --%>
            <c:forEach begin="0" end="${totalPages - 1}" var="i">
                <a class="pagination-link <c:if test="${i eq currentPage}">active</c:if>"
                   href="${pageContext.request.contextPath}/page_report?page=${i}&size=${pageData.size}&sort=${pageable.sort}">
                        ${i + 1}
                </a>
            </c:forEach>

                <%-- Next Page Link --%>
            <c:if test="${!pageData.last}">
                <a class="pagination-link" href="${pageContext.request.contextPath}/page_report?page=${pageData.number + 1}&size=${pageData.size}&sort=${pageable.sort}">
                    Next &gt;&gt;
                </a>
            </c:if>

        </div>

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