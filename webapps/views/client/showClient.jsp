<%@ include file="../includes/header.jsp" %>
<%@ page import="ricemill.model.Client" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<style>
table,th,td{border: 2px solid black;border-collapse: collapse;}
table {width:auto}
th,td{width:auto;align:center;padding-left: 20px;padding-right: 20px;}
#options {background:#8fb7c7}
</style>
    <h1 align="center">${requestScope.title} </h1>
	<table align="center">
		<tr>
			<th> ID </th>
			<th> Name </th>
			<th> Mobile </th>
			<th> Email </th>
			<th> Address </th>
		</tr>
		<c:forEach var="client" items="${requestScope.clients}">
            <tr>
                <td><c:out value="${client.getId()}"/></td>
                <td><c:out value="${client.getName()}"/></td>
                <td><c:out value="${client.getMobile()}"/></td>
                <td><c:out value="${client.getEmail()}"/></td>
                <td><c:out value="${client.getAddress()}"/></td>
                <td><li id="options"><a style="text-decoration:none" href="/ricemill/app/client/update?id=${client.getId()}" >Update</a></li></td>
                <td><li id="options"><a style="text-decoration:none" href="/ricemill/app/client/delete?id=${client.getId()}" >Delete</a></li></td>
            </tr>
        </c:forEach>

	</table>
</body>
</html>


<%@ include file="../includes/footer.jsp" %>