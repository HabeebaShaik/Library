package com.cglia.library;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet2
 */
@SuppressWarnings("serial")
@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int usercnt = LoginDao.getusercount();
		int reqcunt = LoginDao.getreqbookcount();
		 RequestDispatcher rd=request.getRequestDispatcher("Admin.jsp");
		 request.setAttribute("usrcnt", usercnt);
		 request.setAttribute("reqcunt", reqcunt);
	        rd.include(request,response); 
	}

}
