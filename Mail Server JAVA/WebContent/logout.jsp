<%
    request.getSession(false);
	String user = (String) session.getAttribute("UID");
	if(session!=null){
		session.invalidate();
		String redirectURL = "http://localhost:8080/Mail_Server_JAVA/";
        response.sendRedirect(redirectURL);
	}
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@include file="index.jsp" %>
</body>
</html>