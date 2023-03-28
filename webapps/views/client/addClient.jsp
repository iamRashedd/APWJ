<%@ include file="../includes/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<title>Client Insertion Form</title>
</head>
<body>
	<h1 align="center">Client Insertion Form</h1>
	<form method="post">
    <table align="center">
    <tr>
    <td>
    <fieldset>
    <table>
    <tr>
    <th>
		<label for="id">ID:</label>
		</th>
		<td>:</td>
		<td>
		<input type="text" id="id" name="id" >
		</td>
		</tr>
		<tr>
		<th>
		<label for="name">Name:</label>
		</th>
        		<td>:</td>
        		<td>
		<input type="text" id="name" name="name" >
		</td>
        		</tr>
        		<tr>
        		<th>
		<label for="mobile">Mobile:</label>
		</th>
                		<td>:</td>
                		<td>
		<input type="text" id="mobile" name="mobile" >
		</td>
                		</tr>
                		<tr>
                		<th>
		<label for="email">Email:</label>
		</th>
                        		<td>:</td>
                        		<td>
		<input type="email" id="email" name="email" >
		</td>
                        		</tr>
                        		<tr>
                        		<th>
		<label for="balance">Balance:</label>
		</th>
                                		<td>:</td>
                                		<td>
		<input type="number" id="balance" name="balance" >
		</td>
                                		</tr>
                                		<tr>
                                		<th>
		<label for="address">Address:</label>
		</th>
                                        		<td>:</td>
                                        		<td>
		<input type="text" id="address" name="address" />
		</td>
                                        		</tr>
                                        		<tr>
                                        		<th></th><th></th>
                                        		<th>
		<input type="submit" value="Submit">
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