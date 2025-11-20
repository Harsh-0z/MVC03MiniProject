<%@ taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<h1 style="color:blue; text-align:center;">Edit Actor</h1>

<div align="center">
    <frm:form action="${pageContext.request.contextPath}/update"
              method="post" modelAttribute="actor">

        <table bgcolor="lightgreen">

            <tr>
                <td>Actor ID</td>
                <td><frm:input path="aid" readonly="true" /></td>
            </tr>

            <tr>
                <td>Name</td>
                <td><frm:input path="aname" /></td>
            </tr>

            <tr>
                <td>Address</td>
                <td><frm:input path="addrs" /></td>
            </tr>

            <tr>
                <td>Category</td>
                <td><frm:input path="category" /></td>
            </tr>

            <tr>
                <td>Remuneration</td>
                <td><frm:input path="remuneration" /></td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Update" />
                </td>
            </tr>

        </table>

    </frm:form>
</div>
