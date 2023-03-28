<%@ include file="../includes/header.jsp" %>
<%@ page import="ricemill.model.Inventory" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<style>
table,th,td{border: 2px solid black;border-collapse: collapse;}
table {width:auto}
th,td{width:auto;align:center;padding-left: 10px;padding-right: 10px;}
#options {background:#8fb7c7}
</style>
    <h1 align="center">${requestScope.title} </h1>
	<table align="center">
		<tr>
			<th> ID </th>
			<th> Product ID </th>
			<th> Status </th>
			<th> MinStock </th>
			<th> MaxStock </th>
			<th> AvailStock </th>
			<th> Last Update </th>
		</tr>
		<c:forEach var="inventory" items="${requestScope.inventories}">
            <tr>
                <td><c:out value="${inventory.getId()}"/></td>
                <td><c:out value="${inventory.getProduct_id()}"/></td>
                <td><c:out value="${inventory.getStatus()}"/></td>
                <td><c:out value="${inventory.getMin_stock()}"/></td>
                <td><c:out value="${inventory.getMax_stock()}"/></td>
                <td><c:out value="${inventory.getAvailable_stock()}"/></td>
                <td><c:out value="${inventory.getLast_update()}"/></td>
                <td><li id="options"><a style="text-decoration:none" href="/ricemill/app/inventory/update?id=${inventory.getId()}" >Update</a></li></td>
                <td><li id="options"><a style="text-decoration:none" href="/ricemill/app/inventory/delete?id=${inventory.getId()}" >Delete</a></li></td>
            </tr>
        </c:forEach>
	</table>
</body>
</html>

<%@ include file="../includes/footer.jsp" %>
