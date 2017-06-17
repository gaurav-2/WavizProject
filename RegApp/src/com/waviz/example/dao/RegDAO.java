package com.waviz.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class RegDAO {

	private static ResourceBundle rb;
	
	static{
		rb = ResourceBundle.getBundle("db");
	}
	
	public static String getValue(String key){
		return rb.getString(key);
	}
	
	public static Connection createConnection() throws ClassNotFoundException, SQLException{
		
		Class.forName("com.mysql.jdbc.Driver");
		String url = getValue("dburl");
		String userid = getValue("userid");
		String password = getValue("password");
		
		Connection connection = DriverManager.
				getConnection(url,userid,password);

		return connection;
	}
	public int doRegister(String name, String mobile, String mail,
			String pass, String add,String hobbies, String gender) throws ClassNotFoundException, SQLException{
		System.out.println("regdao");
		Connection con = createConnection();
		System.out.println("con creaated");
		PreparedStatement ps = null;
		ps = con.prepareStatement("insert into reg_data values(?,?,?,?,?,?,?)");
		ps.setString(1, name);
		ps.setString(2, mobile);
		ps.setString(3, mail);
		ps.setString(4, pass);
		ps.setString(5, add);
		ps.setString(6, hobbies);
		ps.setString(7, gender);
		int rowUpdated = ps.executeUpdate();
		
		if(rowUpdated>0){
			System.out.println("record added");
		}
		else{
			System.out.println("record not added");
		}
		return rowUpdated;
	}
	
}
