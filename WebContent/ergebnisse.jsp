<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="de.randi2.model.fachklassen.beans.*"
	import="java.util.GregorianCalendar"
	import="java.text.SimpleDateFormat" import="java.util.Locale"
	import="de.randi2.utility.*"%>
<%
			request.setAttribute(DispatcherServlet.requestParameter.TITEL
			.toString(), JspTitel.ERGEBNISSE.toString());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Randi2 :: <%=request
									.getAttribute(DispatcherServlet.requestParameter.TITEL
											.toString())%></title>
<%@include file="include/inc_extjs.jsp"%>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<%@include file="include/inc_header.jsp"%>
<div id="content">
<h1>Studienergebnisse</h1>
<form>
<fieldset><legend><b>Export</b></legend>
<table>
	<tr>
		<td>Export als *.csv</td>
		<td><input type="button" name="exp_csv" value="download"
			tabindex="1" onclick="location.href='ergebnisse_zwei.jsp'"></td>
	</tr>
	<tr>
		<td><br>
		Export als *.xls</td>
		<td><input type="button" name="exp_xls" value="download"
			tabindex="2" onclick="location.href='ergebnisse_zwei.jsp'"></td>
	</tr>
</table>
</fieldset>
</form>

<table align="left">
	<tr>
		<td><input type="button" name="entsp_ja" value="Zur&uuml;ck"
			tabindex="1" onclick="location.href='studie_ansehen.jsp'"></td>
	</tr>
</table>


<%@include file="include/inc_footer.jsp"%></div>
<div id="show_none"><%@include file="include/inc_menue.jsp"%>
</div>
</body>
</html>
