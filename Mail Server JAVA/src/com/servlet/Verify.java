package com.servlet;

import javax.servlet.annotation.WebServlet;
import java.io.*;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connection.DatabaseConnection;
import com.model.MyData;

@WebServlet("/login")
public class Verify extends HttpServlet {

	Connection con = null;
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("uname");
		String pass = req.getParameter("upass");
		PrintWriter out = res.getWriter();
		try {

			con = DatabaseConnection.getCon();
			System.out.println("Connection Created");

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from verify where userid = '"+name+"' and password = '"+pass+"'");
			String dname = "";
			String dpass = "";
			System.out.println("Data Retrived");
			while (rs.next()) {
				System.out.println("Data Retrived");
				dname = rs.getString(1);
				dpass = rs.getString(2);
				System.out.println("Correct");

				if (dname.equals(name) && dpass.equals(pass)) {
					System.out.println("Checking Id and Password");
					    HttpSession hs = req.getSession();
					    hs.setAttribute("UID",name);
						RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
					    rd.forward(req, res);
					    System.out.print("User Sucessfully logged in");
					    System.out.println("User Name is : "+ dname );
					
					
				} else {
					RequestDispatcher rd = req.getRequestDispatcher("LoginFailure.jsp");
					rd.include(req, res);
				}
			}
			con.close();
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
