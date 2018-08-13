package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.connection.DatabaseConnection;
import com.model.MyData;

public class MyDataDAOImpl implements MyDataDAO {

	Statement stmt, stmt2;
	ResultSet rs;
	private static Connection con;
	static {
		try {
			con = DatabaseConnection.getCon();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean addUser(MyData m) {
		String userQuery = "insert into verify values('" + m.getUserid() + "','" + m.getPassword() + "','"
				+ m.getFname() + "','" + m.getLname() + "','" + m.getDob() + "','" + m.getGender() + "','"
				+ m.getMobile() + "','" + m.getCountry() + "')";
		String verificationQuery = "select * from verify where userid =('" + m.getUserid() + "')";
		try {
			stmt = con.createStatement();
			stmt2 = con.createStatement();
			rs = stmt.executeQuery(verificationQuery);
			while (rs.next()) {
				return false;
			}
			int i = stmt2.executeUpdate(userQuery);
			if (i >= 1) {
				return true;
			}
			stmt.close();
			stmt2.close();
			rs.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
