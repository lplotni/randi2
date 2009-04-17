<!-- 
 The login page.

 Made by lplotni@users.sourceforge.org  

 This file is part of RANDI2.
 RANDI2 is free software: you can redistribute it and or modify it under the
 terms of the GNU General Public License as published by the Free Software
 Foundation, either version 3 of the License, or (at your option) any later
 version.
 RANDI2 is distributed in the hope that it will be useful, but WITHOUT ANY
 WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 You should have received a copy of the GNU General Public License along with
 RANDI2. If not, see http://www.gnu.org/licenses/.
 -->
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt'%>
<%@ page
	import="org.springframework.security.ui.AbstractProcessingFilter"%>
<%@ page
	import="org.springframework.security.ui.webapp.AuthenticationProcessingFilter"%>
<%@ page import="org.springframework.security.AuthenticationException"%>
<html>
<head>
<title>Login</title>
</head>
<body>
<%
	if (request.getParameter("login_error") != null) {
%>
<div id="loginError" style="position: absolute; left: 30%;"><font
	color="red"> Your login attempt was not successful, try again. <BR />
Reason: <%=((AuthenticationException) session
										.getAttribute(AbstractProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY))
										.getMessage()%>
</font></div>
<%
	}
%>
<div id="login"
	style="top: 10%; position: absolute; left: 30%; width: 505px; height: 250px; background-image: url('img/background1.gif');">
<form action="<c:url value='j_spring_security_check'/>" method="POST">
<br />
<br />
<br />
<br />
<br />
<br />
<table style="position: relative; left: 35%;" cellpadding="3">
	<tr>
		<td><span style="font-weight: bold; color: #FFFFFF;">Username:</span></td>
		<td><input type='text' name='j_username'></td>
	</tr>
	<tr>
		<td><span style="font-weight: bold; color: #FFFFFF;">Password:</span></td>
		<td><input type='password' name='j_password'></td>
	</tr>
	<tr>
		<td colspan='2'><input value="Log in" type="submit"
			style="position: relative; left: 180px;"></td>
	</tr>
	<tr>
	</tr>
	<tfoot>
		<tr>
			<td><a href="register.jspx"
				style="font-weight: bold; color: #FFFFFF;">Register</a></td>
			<td><a href="terms.jspx"
				style="font-weight: bold; color: #FFFFFF;">Terms of use</a></td>
		</tr>
	</tfoot>
</table>
</form>
</div>
</body>
</html>

