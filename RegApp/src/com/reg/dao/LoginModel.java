package com.reg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel {
	
	public boolean checkLogin(String email, String password) throws ClassNotFoundException, SQLException{
		
		boolean status = false;
		Connection con = RegDAO.createConnection();
		PreparedStatement ps;
		 ps=con.prepareStatement("select * from reg_data where email=? and password=?");  
				ps.setString(1,email);  
				ps.setString(2,password);  
				      
				ResultSet rs=ps.executeQuery();  
				status=rs.next(); 
				return status;
	}

}
