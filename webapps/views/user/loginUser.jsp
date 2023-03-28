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
		<h1>${requestScope.title} </h1>

		<form method="post">
			<table>
				<tr>
					<td>
						<fieldset>
							<legend><b>Login: </b></legend>
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
									<th></th>
									<td></td>
									<td align="right">
										<input type="submit" value="Login">
									</td>
								</tr>
							</table>
						</fieldset>
					</td>
				</tr>
			</table>
		</form>

        ${requestScope.error}

		<p>Don't have an account? Register <a href="/ricemill/user/register">here</a>.</p>
	</div>

</body>
</html>


<%@ include file="../includes/footer.jsp" %>