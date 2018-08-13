package com.servlet;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class Logout extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException {
		HttpSession session = req.getSession();
        session.invalidate();
        String redirectURL = "http://localhost:8080/Mail_Server_JAVA/";
        res.sendRedirect(redirectURL);
	}
}
