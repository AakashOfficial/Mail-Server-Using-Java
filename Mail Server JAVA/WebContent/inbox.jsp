<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Inbox</title>
</head>
<body>

	<%@ page import="java.util.*"%>
	<%@ page import="java.sql.Connection"%>
	<%@ page import="java.sql.DriverManager"%>
	<%@ page import=" java.sql.ResultSet"%>
	<%@ page import="java.sql.Statement"%>
	<%
		String user = (String) session.getAttribute("UID");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/javamailbox";
			String username = "root";
			String password = "";
			String query = "select * from draft where receiver='" + user + "'";
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
	%>
	<div align="center">
		<table border="2" align="center" cellpadding="20" cellspacing="5">
			<tr>
				<th>From</th>
				<th>Subject</th>
				<th>Message</th>
				<th>Date & Time</th>
			</tr>
			<%
				while (rs.next()) {
			%>
			<TR>
				<TD><%=rs.getString(2)%></td>
				<TD><%=rs.getString(4)%></TD>
				<TD><%=rs.getString(5)%></TD>
				<TD><%=rs.getString(6)%></TD>
			</TR>
			<%
				}
			%>
		</TABLE>

		<%
			rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		%>
	</div>
</body>
</html>