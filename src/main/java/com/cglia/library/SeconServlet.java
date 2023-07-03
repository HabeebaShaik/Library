package com.cglia.library;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SeconServlet
 */
@SuppressWarnings("serial")
@WebServlet("/SecondServlet")
public class SeconServlet extends HttpServlet {
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=null;
		String UserName=null;
		String Age=null;
		String Gender=null;
		String Email=null;
		String State=null;
		String City=null;
		String Password=null;
		int min=1000;
		int max=9999;
		try {
			UserName=request.getParameter("UserName");
			Age="18";
			Gender=request.getParameter("gender");
			Email=request.getParameter("email");
			State=request.getParameter("State");
			City=request.getParameter("city");
			Password=request.getParameter("password");
			int b = (int)(Math.random()*(max-min+1)+min);   
			User user=new User();
			user.setUserName(UserName);
			user.setAge(Integer.parseInt(Age));
			user.setGender(Gender);
			user.setEmail(Email);
			user.setState(State);
			user.setCity(City);
			user.setPassword(Password);
			user.setUserId(b);
			String status = LoginDao.save(user);
			RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");  
			request.setAttribute("userid", b);
			rd.include(request,response);  
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	}
