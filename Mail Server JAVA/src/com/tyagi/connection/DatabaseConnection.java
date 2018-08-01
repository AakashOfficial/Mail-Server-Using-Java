package com.tyagi.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnection {
	
	

	private static String mysql_driverName = "com.mysql.jdbc.Driver";
	private static String mysql_dbUrl = "jdbc:mysql://localhost:3306/mail_server";
	private static String mysql_userName = "root";
	private static String mysql_dbPass = "";

	

	public static Connection getCon() throws Exception {
		Class.forName(mysql_driverName);
		Connection con = DriverManager.getConnection(mysql_dbUrl, mysql_userName, mysql_dbPass);
		return con;
	}

}