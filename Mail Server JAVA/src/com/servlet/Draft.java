package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connection.DatabaseConnection;

@WebServlet("/savetodraft")
public class Draft extends HttpServlet {

	Connection con;
	Statement stmt,stmt2;
	int i;
	public void service(HttpServletRequest req, HttpServletResponse res ) throws IOException {
		PrintWriter out = res.getWriter();
		HttpSession hs = req.getSession();
		String userlog =(String)hs.getAttribute("UID");
		String sendto = req.getParameter("to");
		String subject = req.getParameter("subject");
		String msg = req.getParameter("msg");
		try {
			String draftQuery = "insert into draft values('"+userlog+"','"+sendto+"','"+subject+"','"+msg+"')";
			String userConfirm = "select * from verify where userid = '"+userlog+"'";
			con = DatabaseConnection.getCon();
			System.out.println("Connection Created");
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(userConfirm);
			while(rs.next()) {
				stmt2 = con.createStatement();
			    i = stmt2.executeUpdate(draftQuery);
				
			}
			if(i == 1) {
				out.print("Message Sent");
				out.print("<script>alert('Save To Draft');</script>");
			}			else {
				RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
				rd.forward(req, res);
				out.print("<script>alert('Not Save To Draft');</script>");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
