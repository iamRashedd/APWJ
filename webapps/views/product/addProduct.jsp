<%@ include file="../includes/header.jsp" %>
<%@ page import="ricemill.model.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Add Product</title>
</head>
<body>
	<h1 align="center">Add Product</h1>

	<form method="post">
	<table align="center">
	    <tr>
	        <td>
	            <fieldset>
	                <table>
	                    <tr>
	                        <th>
		                        <label for="id">ID</label>
		                    </th>
		                    <td>:</td>
		                    <td>
		                        <input type="number" id="id" name="id" value=${requestScope.product.getId()}>
                            </td>
                        </tr>
                        <tr>
                            <td></td><td></td>
                            <td>
                                ${requestScope.idError}
                            </td>
                        </tr>
                        <tr>
                            <th>
		                        <label for="category">Category</label>
	                        </th>
		                    <td>:</td>
		                    <td>
		                        <input type="text" id="category" name="category" value=${requestScope.product.getCategory()}>
                            </td>
                        </tr>
                        <tr>
                            <td></td><td></td>
                            <td>
                                ${requestScope.categoryError}
                            </td>
                        </tr>
                        <tr>
                            <th>
		                        <label for="subcategory">Subcategory</label>
	                        </th>
		                    <td>:</td>
		                    <td>
		                        <input type="text" id="subcategory" name="subcategory" value=${requestScope.product.getSubcategory()}>
                            </td>
                        </tr>
                        <tr>
                            <td></td><td></td>
                            <td>
                                ${requestScope.subcategoryError}
                            </td>
                        </tr>
                        <tr>
                            <th>
                                <label for="name">Name</label>
	                        </th>
		                    <td>:</td>
		                    <td>
		                        <input type="text" id="name" name="name" value=${requestScope.product.getName()}>
                            </td>
                        </tr>
                        <tr>
                            <td></td><td></td>
                            <td>
                                ${requestScope.nameError}
                            </td>
                        </tr>
                        <tr>
                            <th>
                                <label for="price">Price:</label>
	                        </th>
		                    <td>:</td>
                            <td>
		                        <input type="number" id="price" name="price" value=${requestScope.product.getPrice()}>
                            </td>
                        </tr>
                        <tr>
                            <td></td><td></td>
                            <td>
                                ${requestScope.priceError}
                            </td>
                        </tr>
                        <tr>
                        <th></th><th></th>
                        <th>
		                    <input type="submit" value="Add Product">
                        </th>
                    </tr>
                    <tr>
                        <td>
                            ${requestScope.errorMsg}
                        </td>
                    </tr>
                </table>
            </form>
</body>
</html>


<%@ include file="../includes/footer.jsp" %>