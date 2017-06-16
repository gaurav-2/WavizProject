package com.reg.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reg.dao.RegDAO;
import com.reg.dao.RegDTO;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/home")
public class HomeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String mobile = request.getParameter("mobile");
		String mail = request.getParameter("mail");
		String pass = request.getParameter("pass");
		String add = request.getParameter("add");
		String hobbies = "";
		String hobby[] = request.getParameterValues("hobby");
		for(int i = 0; i<hobby.length; i++){
			hobbies += hobby+" ";  
		}
		String gender = request.getParameter("gender");
		System.out.println(gender);
		try {
			System.out.println("h1");
			RegDAO rd = new RegDAO();
			
			rd.doRegister(name, mobile, mail, pass ,add, hobbies, gender);
			System.out.println("h2");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	System.out.println("hi");
	}
	
	

	
	/*private void doRegister(String name, String mobile, String mail, String pass, String repass, String add,
			String hobbies, String gender) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("hi again");
		
		RegDAO rd = new RegDAO();
		rd.doRegister(name, mobile, mail,pass, add, hobbies, gender);
		
		System.out.println("hi again again");
	}*/
}
