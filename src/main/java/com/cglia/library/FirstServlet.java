package com.cglia.library;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@SuppressWarnings("serial")
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   response.setContentType("text/html");  
		    PrintWriter out = response.getWriter();  
		          
		    String n=request.getParameter("userId");  
		    String p=request.getParameter("password");  
		      String role=  LoginDao.validate(n, p); 
		      
		    if(role != null){  
		    	int userid = Integer.parseInt(n);
		    	if(role.equals("Admin")) {
		    		
		    		int reqbookcunt = LoginDao.getreqbookcount();
		    		String adminname = null;
		    		try {
						 adminname = LoginDao.getusernameid(userid);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        RequestDispatcher rd=request.getRequestDispatcher("Servlet2");
		        request.setAttribute("username", adminname);
		        request.setAttribute("reqcunt", reqbookcunt);
		        
		        rd.include(request,response);
		    }  
		    	else {
		    		try {
		    		
		    		String name = LoginDao.getusernamebyid(userid);
		    		
			        RequestDispatcher rd=request.getRequestDispatcher("Userhomepageservlet");  
			        request.setAttribute("userid", n);
			        request.setAttribute("username", name);
			       
			        rd.include(request,response);
		    		}catch(Exception e) {
		    			e.printStackTrace();
		    		}
 
		    	}
		    }
		    else{  
		    	String msg= "Invalid Username or Password";
		    	request.setAttribute("error",msg);
		        RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");  
		        rd.include(request,response);  
		    }  
		          
		    out.close();  
		    } 
	}
