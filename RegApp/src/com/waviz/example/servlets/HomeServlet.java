package com.waviz.example.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.waviz.example.dao.RegDAO;


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
		String repass = request.getParameter("repass");
		String add = request.getParameter("add");
		String hobbies = "hobbies-->";
		String hobby[] = request.getParameterValues("hobby");
		for(int i = 0; i<hobby.length; i++){
			hobbies += hobby+" ";  
		}
		String gender = request.getParameter("gender");
	//	System.out.println(gender);
		
		/*if((pass.equals(repass))&&(name!=null || mobile!=null ||mail!=null||pass!=null||add!=null||
				hobbies!=null||gender!=null))
		{*/
		try {
			System.out.println("h1");
			RegDAO rd = new RegDAO();
			
			int rowUpdated = rd.doRegister(name, mobile, mail, pass ,add, hobbies, gender);
		//	System.out.println("h2");
			if(rowUpdated>0){
				HttpSession session = request.getSession();
				session.setAttribute("user", name);
				response.sendRedirect("welcome");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	}
		/*else{
			response.sendRedirect("index.jsp");
		}*/
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
