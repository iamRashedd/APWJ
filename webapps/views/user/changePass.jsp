<%@ include file="../includes/header.jsp" %>
<h1 align="center">${requestScope.title} </h1>
<form method="post" >
    <table align="center">
    <tr>
    <td>
    <fieldset>
            <table align="center">
                <tr>
                    <th>
                        <label for="current_password">Current Password</label>
                    </th>
                    <td>:</td>
                    <td>
                        <input type="password" name="current_password" id="current_password" value=${requestScope.currentPassword}>
                    </td>
                    <td>
                        ${requestScope.currentPasswordErrMsg}
                    </td>
                </tr>
                <tr>
                    <th>
                        <label for="new_password">New Password</label>
                    </th>
                    <td>:</td>
                    <td>
                        <input type="password" name="new_password" id="new_password">
                    </td>
                    <td>
                        ${requestScope.newPasswordErrMsg}
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
                        ${requestScope.confirmPasswordErrMsg}
                    </td>
                </tr>
                <tr>
                    <th></th>
                    <td></td>
                    <td align="right">
                        <input type="submit" value="Change Password">
                    </td>
                </tr>
            </table>
            </fieldset>
            </td>
            </tr>
            </table>
		</form>

<%@ include file="../includes/footer.jsp" %>