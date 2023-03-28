<%@ include file="../includes/header.jsp" %>
<%@ page import="ricemill.model.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Update User</title>
	<style>
	button { font-size: 15px;border-radius: 8px;}
	</style>
</head>
<body align="center">
	<h1>Update User</h1>
	<form method="post">
	<table align="center">
	<tr>
	<td>
	<fieldset>
        <table align="center">
            <tr>
                <th>
                    <label >Email:</label>
                </th>
                <td>
                    <input type="email" id="email" name="email" value="${user.getEmail()}" readonly><br><br>
                </td>
                <td>
                    ${requestScope.emailError}
                </td>
            </tr>
            <tr>
                <th>
                    <label >Account Type:</label>
                </th>
                <td>
                    <input type="text" name="type" value="${user.getType()}" readonly><br><br>
                </td>
                <td>
                    ${requestScope.typeError}
                </td>
            </tr>
            <tr>
                <th>
                    <label >Name:</label>
                </th>
                <td>
                    <input type="text" id="name" name="name" value="${user.getName()}"><br><br>
                </td>
                <td>
                    ${requestScope.nameError}
                </td>
            </tr>
            <tr>
                <th>
                    <label >Address:</label>
                </th>
                <td>
                    <input type="text" id="address" name="address" value="${user.getAddress()}"><br><br>
                </td>
                <td>
                    ${requestScope.addressError}
                </td>
            </tr>
            <tr>
                <th>
                    <label >Current Password:</label>
                </th>
                <td>
                    <input type="password" id="password" name="password" value=""><br><br>
                </td>
                <td>
                    ${requestScope.passwordError}
                </td>
            </tr>

            <tr>
                <th>
                    <button><a style="text-decoration:none;" href="/ricemill/app/user/changepass">Change Password</a></button>
                </th>
                <th>
                    <input type="submit" value="Update Information">
                </th>
                <td>
                    ${requestScope.errorMsg}
                </td>
            </tr>
        </table>
        </fieldset>
        </td>
        </tr>
        <table>
	</form>

</body>
</html>


<%@ include file="../includes/footer.jsp" %>
