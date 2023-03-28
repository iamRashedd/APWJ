<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Login</title>
</head>
<body>

	<div align="center">
		<h1>${requestScope.title}</h1>

		<form method="post">
			<table>
				<tr>
					<td>
						<fieldset>
							<legend><b>${requestScope.title}:</b></legend>
							<table>
								<tr>
									<th>
										<label for="email">Email</label>
									</th>
									<td>:</td>
									<td>
										<input type="email" name="email" id="email" value=${requestScope.email}>
									</td>
									<td>
									    ${requestScope.emailError}
  									</td>
								</tr>
								<tr>
                                    <th>
                                        <label for="name">Name</label>
                                    </th>
                                    <td>:</td>
                                    <td>
                                        <input type="text" name="name" id="name" value=${requestScope.name}>
                                    </td>
                                    <td>
                                        ${requestScope.nameError}
                                    </td>
                                </tr>
                                <tr>
                                    <th>
                                        <label for="address">Address</label>
                                    </th>
                                    <td>:</td>
                                    <td>
                                        <input type="text" name="address" id="address" value=${requestScope.address}>
                                    </td>
                                    <td>
                                        ${requestScope.addressError}
                                    </td>
                                </tr>
                                <tr>
                                    <th>
                                        <label for="type">Type</label>
                                    </th>
                                    <td>:</td>
                                    <td>
                                        <select id="type">
                                            <option value="user">USER</option>
                                            <option value="admin">ADMIN</option>
                                        </select>
                                    </td>
                                    <td>
                                        ${requestScope.addressError}
                                    </td>
                                </tr>
								<tr>
									<th>
										<label for="password">Password</label>
									</th>
									<td>:</td>
									<td>
										<input type="password" name="password" id="password">
									</td>
									<td>
									    ${requestScope.passwordError}
									</td>
								</tr>
								<tr>
                                    <th>
                                        <label for="confirm_password">Confirm Password</label>
                                    </th>
                                    <td>:</td>
                                    <td>
                                        <input type="password" name="confirm_password" id="confirm_password">
                                    </td>
                                    <td>
                                        ${requestScope.confirmPassError}
                                    </td>
                                </tr>

								<tr>
									<th></th>
									<td align="right">
										<input type="submit" value="Register">
									</td>
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

        ${requestScope.errMsg}

		<p>Already have an account? Login <a href="/ricemill/user/login">here</a>.</p>
	</div>

</body>
</html>

<%@ include file="../includes/footer.jsp" %>