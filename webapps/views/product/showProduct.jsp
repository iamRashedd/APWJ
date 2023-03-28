<%@ include file="../includes/header.jsp" %>
<%@ page import="ricemill.model.Product" %>
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
			<th >ID</th>
			<th >Name</th>
			<th >Category</th>
			<th >Subcategory</th>
			<th >Price</th>
		</tr>
		<c:forEach var="product" items="${requestScope.products}">
            <tr>
                <td><c:out value="${product.getId()}"/></td>
                <td><c:out value="${product.getName()}"/></td>
                <td><c:out value="${product.getCategory()}"/></td>
                <td><c:out value="${product.getSubcategory()}"/></td>
                <td><c:out value="${product.getPrice()}"/></td>
                <td><li id="options"><a style="text-decoration:none" href="/ricemill/app/product/update?id=${product.getId()}" >Update</a></li></td>
                <td><li id="options"><a style="text-decoration:none" href="/ricemill/app/product/delete?id=${product.getId()}" >Delete</a></li></td>
            </tr>
        </c:forEach>

	</table>
</body>
</html>
