package com.reg.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reg.dao.LoginModel;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	private int counter;
	@Override
	public void init(){
		counter = 3;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		try {
			LoginModel lm = new LoginModel();
			boolean status = lm.checkLogin(email,pass);
			
			if(status){
				System.out.println("login success");
				request.setAttribute("msg", email);
				RequestDispatcher rd = request.getRequestDispatcher("welcome");
				rd.forward(request, response);
			}
			else{
				System.out.println("number of attempts left "+(--counter));
				if(counter < 1){
					request.setAttribute("captcha", LoginServlet.generateCaptcha());
					RequestDispatcher rd = request.getRequestDispatcher("loginerror.jsp");
					rd.forward(request, response);
				}
				else{
				request.setAttribute("counter", counter);
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
				}
				//if(counter == 0)//{
				//	generateCaptcha();
				//}
			//	out.print("invalid email or password");
				//response.sendRedirect("login.jsp");
	
				/*RequestDispatcher rd = request.getRequestDispatcher("index.html");
				rd.include(request, response);*/
		}
		} 
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static String generateCaptcha() {
		
		Random random = new Random();
		int length = 5 ;

		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int baseCharNumber = Math.abs(random.nextInt()) % 62;
			int charNumber = 0;
			if (baseCharNumber < 26) {
				charNumber = 65 + baseCharNumber;
			}
			else if (baseCharNumber < 52){
				charNumber = 97 + (baseCharNumber - 26);
			}
			else {
				charNumber = 48 + (baseCharNumber - 52);
			}
			buffer.append((char)charNumber);
		}

		return buffer.toString();
	}

	

}
