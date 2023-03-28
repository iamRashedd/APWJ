<%@ include file="../includes/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<title>Client Update</title>
</head>
<body>
	<h1 align="center">Client Update</h1>
	<form method="post">
	<table align="center">
	    <tr>
	        <td>
            <fieldset>
            <table>
                <tr>
                    <th>
		                <label >ID</label>
		            </th>
		            <td>:</td>
		            <td>
		                <input type="text" name="id" value="${client.getId()}" readonly><br><br>
		            </td>
		        </tr>
		        <tr>
		            <th>
		                <label >Name</label>
                    </th>
                    <td>:</td>
                    <td>
		                <input type="text" name="name" value="${client.getName()}" ><br><br>
		            </td>
                </tr>
                <tr>
                    <th>
		                <label >Mobile</label>
                    </th>
                    <td>:</td>
                    <td>
		                <input type="text"  name="mobile" value="${client.getMobile()}" ><br><br>
		            </td>
                </tr>
                <tr>
                    <th>
		                <label >Email</label>
                    </th>
                    <td>:</td>
                    <td>
		                <input type="email" name="email" value="${client.getEmail()}" ><br><br>
                    </td>
                </tr>
                <tr>
                    <th>
		                <label >Balance</label>
                    </th>
                    <td>:</td>
                    <td>
		                <input type="number"  name="balance" value="${client.getBalance()}" ><br><br>
                    </td>
                </tr>
                <tr>
                    <th>
		                <label >Address</label>
                    </th>
                    <td>:</td>
                    <td>
		                <input type="text" name="address" value="${client.getAddress()}" ></textarea><br><br>
		            </td>
                </tr>
                <tr>
                    <th></th>
		<input type="submit" value="Update">
            </fieldset>
		    </td>
		</tr>
    </table
	</form>
</body>
</html>


<%@ include file="../includes/footer.jsp" %>