<%@ taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Actor Registration</title>
</head>
<body>

<h1 style="color:red; text-align:center;">Actor Registration Form</h1>

<div align="center">

    <frm:form
            action="${pageContext.request.contextPath}/add"
            method="post"
            modelAttribute="actor">

        <table bgcolor="cyan" cellpadding="10">

            <tr>
                <td>Actor Name</td>
                <td><frm:input path="aname" type="text" /></td>
            </tr>

            <tr>
                <td>Actor Address</td>
                <td><frm:input path="addrs" type="text" /></td>
            </tr>

            <tr>
                <td>Actor Category</td>
                <td><frm:input path="category" type="text" /></td>
            </tr>

            <tr>
                <td>Actor Remuneration</td>
                <td><frm:input path="remuneration" type="text" /></td>
            </tr>

            <tr>
                <td>
                    <input type="submit" value="Register" />
                </td>
                <td>
                    <input type="reset" value="Cancel" />
                </td>
            </tr>

        </table>

    </frm:form>

</div>

</body>
</html>
