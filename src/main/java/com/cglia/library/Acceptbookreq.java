package com.cglia.library;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Acceptbookreq
 */
@WebServlet("/acceptbook")
public class Acceptbookreq extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bookid= Integer.parseInt(request.getParameter("bookid"));

		try {
			LoginDao.acceptreq( bookid);
			int cnt =LoginDao.getreqbookcount();
			 RequestDispatcher rd=request.getRequestDispatcher("bookrequest"); 
			 if( cnt<1) {
				 request.setAttribute("msg", "No records Available");
			 }
		        rd.forward(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
