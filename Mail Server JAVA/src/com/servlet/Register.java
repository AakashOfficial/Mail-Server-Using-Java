package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.MyDataDAO;
import com.dao.MyDataDAOImpl;
import com.model.MyData;

@WebServlet("/register")
public class Register extends HttpServlet {

	MyData m = new MyData();

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		String month = req.getParameter("bd_month");
		String date = req.getParameter("bd_date");
		String year = req.getParameter("bd_year");
		String dob = date+"-"+month+"-"+year;
		m.setUserid(req.getParameter("uname"));
		m.setPassword(req.getParameter("pass"));
		m.setFname(req.getParameter("fname"));
		m.setLname(req.getParameter("lname"));
		m.setDob(dob);
		m.setGender(req.getParameter("gender"));
		m.setMobile(req.getParameter("mobile"));
		m.setCountry(req.getParameter("country"));

		String password = req.getParameter("pass");
		String conform = req.getParameter("cfpass");
		
		System.out.println("Value Taken");
		if (password.equals(conform)) {
			System.out.println("Inside");
			MyDataDAO myDAO = new MyDataDAOImpl();
			boolean result = myDAO.addUser(m);

			System.out.println("Method Call");
			if (result == true) {
				RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
				rd.forward(req, res);
				System.out.print("User Sucessfully Registered ");
				System.out.println("User Name is : " + m.getFname());
				System.out.println("User ID is : " + m.getUserid());
				out.println("<script>alert('User is Successfully Registered....');</script>");
			} else {
				RequestDispatcher rd = req.getRequestDispatcher("register.jsp");
				rd.forward(req, res);
				out.print("<script>alert('User Not Registered. Please Check All Values You Inserted....');</script>");
			}
		} else {
			out.print("<script>alert('Password and Conform Password is Not Same');</script>");
		}

		out.close();
	}
}