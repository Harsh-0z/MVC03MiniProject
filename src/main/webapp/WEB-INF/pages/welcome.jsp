<%@ page isELIgnored="false" %>

<h1 style="color:cyan; text-align:center;">
    Welcome to Home Page
</h1>

<div style="background-color:red; text-align:center; padding:20px;">

    <a href="${pageContext.request.contextPath}/report">
        <img src="${pageContext.request.contextPath}/images/report.png"
             alt="report image"
             width="150px">
    </a>

    <a href="${pageContext.request.contextPath}/page_report">
        Report By Pagination
    </a>

</div>
