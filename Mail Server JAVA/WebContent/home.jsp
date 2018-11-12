<%
    HttpSession hs = request.getSession();
	String user = (String) session.getAttribute("UID");
	if (user == null) {
		/* RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response); */
		
		// This is For Redirect the URL to Default Page if User is Not Login and Trying to edit the Web Link To the Web Browser.
		String redirectURL = "http://localhost:8080/Mail_Server_JAVA/";
                response.sendRedirect(redirectURL);
	}
%>
<html>
<head>
<title>Mail Box</title>
<link rel="stylesheet" type="text/css" href="css/style2.css">
<link rel="stylesheet" type="text/css" href="css/V_Menu.css">
</head>
<body>
	<div id="mainbody">
		<div id="wrapper">
			<div id="header">
				<img src="image/icon_2.jpg" width="200"></img></img> <a href="logout.jsp"><img
					src="image/logout-button-purple-hi.png" align="right" width="100"></a>
			</div>
			<div id="center">
				<a href="barimage.bmp"></a>
				<div class="left">
					<ul class="menu">
						<li><a href="compose.jsp" target="a">Compose>></a></li>
						<li><a href="inbox.jsp" target="a">InBox</a></li>
						<li><a href="sent.jsp" target="a">SENT</a></li>
						<li><a href="draft.jsp" target="a">DRAFT</a></li>
						<li><a href="#"><img src="image/sdsss.png" width="85" height="60"></img></a></li>
					</ul>
				</div>
				<div class="contents" id="content">
					<br>
					<iframe name="a" height="500" width="500" src="inbox.jsp"
						scrolling="no" frameborder="0"></iframe>
				</div>
			</div>
			<div id="footer">
				<p class="style12" align="center">
					<font size="+1"><b>© mailBOX.com 2018</b></font>
				</p>
			</div>
		</div>
	</div>
	</img>
</body>
</html>
