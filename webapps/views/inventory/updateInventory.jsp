<%@ include file="../includes/header.jsp" %>
<%@ page import="ricemill.model.Inventory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Update Inventory</title>
</head>
<body>
	<h1 align="center">Update Inventory</h1>

	<form method="post">
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
		            <input type="int"  name="id" value="${inventory.getId()}" readonly><br><br>
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
		            <label >Product ID</label>
		        </th>
		        <td>:</td>
		        <td>
		            <input type="int"  name="product_id" value="${inventory.getProduct_id()}"  readonly><br><br>
                </td>
            </tr>
            <tr>
                <td></td><td></td>
                <td>
                    ${requestScope.product_idError}
                </td>
            </tr>
            <tr>
                <th>
		            <label >Status</label>
		        </th>
		        <td>:</td>
		        <td>
		            <input type="text" name="status" value="${inventory.getStatus()}" ><br><br>
		        </td>
            </tr>
            <tr>
                <td></td><td></td>
                <td>
                    ${requestScope.statusError}
                </td>
            </tr>
            <tr>
                <th>
		            <label >Minimum Stock</label>
	            </th>
		        <td>:</td>
		        <td>
		            <input type="number"  name="min_stock" value="${inventory.getMin_stock()}" ><br><br>
                </td>
            </tr>
            <tr>
                <td></td><td></td>
                <td>
                    ${requestScope.min_stockError}
                </td>
            </tr>
            <tr>
                <th>
		            <label >Maximum Stock</label>
	            </th>
	            <td>:</td>
		        <td>
		            <input type="number"  name="max_stock" value="${inventory.getMax_stock()}" ><br><br>
                </td>
            </tr>
            <tr>
                <td></td><td></td>
                <td>
                    ${requestScope.max_stockError}
                </td>
            </tr>
            <tr>
                <th>
		            <label >Available Stock</label>
	            </th>
	            <td>:</td>
		        <td>
		            <input type="number"  name="available_stock" value="${inventory.getAvailable_stock()}" ><br><br>
                </td>
            </tr>
            <tr>
                <td></td><td></td>
                <td>
                    ${requestScope.available_stockError}
                </td>
            </tr>
            <tr>
                <th>
		            <label >Last Update</label>
                </th>
                <td>:</td>
	            <td>
                    <input type="datetime-local"  name="last_update" value="${inventory.getLast_update()}" readonly><br><br>
                </td>
            </tr>
            <tr>
                <td></td><td></td>
                <td>
                    ${requestScope.last_updateError}
                </td>
            </tr>
            <tr>
                <th>
                </th>
                <th>
		            <input type="submit" value="Update Inventory">
                </th>
            </tr>
            <tr>
                <td></td><td></td>
                <td>
                    ${requestScope.errorMsg}
                </td>
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