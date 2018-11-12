<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Draft</title>
</head>
<body>

	<%
		String user = (String) session.getAttribute("UID");
	%>

	<%@ page import="java.util.*"%>
	<%@ page import="java.sql.Connection"%>
	<%@ page import="java.sql.DriverManager"%>
	<%@ page import=" java.sql.ResultSet"%>
	<%@ page import="java.sql.Statement"%>
	<%
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/javamailbox";
			String username = "root";
			String password = "";
			String query = "select * from draft where sender='" + user + "'";
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
	%>
	<div align="center">
		<table border="2" align="center" cellpadding="10" cellspacing="5">
			<tr>
				<th>From</th>
				<th>To</th>
				<th>Subject</th>
				<th>Message</th>
			</tr>
			<%
				while (rs.next()) {
			%>
			<TR>
				<TD><%=rs.getString(1)%></td>
				<TD><%=rs.getString(2)%></TD>
				<TD><%=rs.getString(3)%></TD>
				<TD><%=rs.getString(4)%></TD>
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
