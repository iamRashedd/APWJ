<%@ include file="../includes/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Update Product</title>
</head>
<body>
	<h1 align="center">Update Product</h1>

	<form action="updateProduct.jsp" method="post">
	<table align="center">
	<tr>
	<td>
	<fieldset>
	    <table align="center">
	        <tr>
	            <th>
		            <label >ID</label>
		        </th>
		        <td>:</td>
		        <td>
		            <input type="text"  name="id" value="${product.getId()}" readonly><br><br>
                </td>
                <td>
                    ${requestScope.idError}
                </td>
            </tr>
            <tr>
                <th>
                    <label >Category</label>
	            </th>
	            <td>:</td>
		        <td>
		            <input type="text"  name="category" value="${product.getCategory()}"><br><br>
                </td>
                <td>
                    ${requestScope.categoryError}
                </td>
            </tr>
            <tr>
                <th>
		            <label >Subcategory</label>
	            </th>
	            <td>:</td>
	            <td>
		            <input type="text"  name="subcategory" value="${product.getSubcategory()}"><br><br>
                </td>
                <td>
                    ${requestScope.subcategoryError}
                </td>
            </tr>
            <tr>
                <th>
		            <label >Name</label>
		        </th>
		        <td>:</td>
		        <td>
		            <input type="text"  name="name" value="${product.getName()}"><br><br>
                </td>
                <td>
                    ${requestScope.nameError}
                </td>
            </tr>
            <tr>
                <th>
                    <label >Price</label>
		        </th>
		        <td>:</td>
		        <td>
		            <input type="number"  name="price" value="${product.getPrice()}"><br><br>
                </td>
                <td>
                    ${requestScope.priceError}
                </td>
            </tr>
            <tr>
                <th>
                </th>
                <td>
                </td>
                <th>
		            <input type="submit" value="Update Product">
                </th>
            </tr>
        </table>
        </fieldset>
        </td>
        </tr>
        </table>
	</form>

</body>
</html>


<%@ include file="../includes/footer.jsp" %>